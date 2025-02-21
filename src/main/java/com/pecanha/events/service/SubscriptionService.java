package com.pecanha.events.service;

import com.pecanha.events.dto.SubscriptionRankingByUser;
import com.pecanha.events.dto.SubscriptionRankingItem;
import com.pecanha.events.dto.SubscriptionResponse;
import com.pecanha.events.exception.SubscriptionConflictException;
import com.pecanha.events.exception.EventNotFoundException;
import com.pecanha.events.exception.UserIndicadorNotFoundException;
import com.pecanha.events.model.Event;
import com.pecanha.events.model.Subscription;
import com.pecanha.events.model.User;
import com.pecanha.events.repository.EventRepository;
import com.pecanha.events.repository.SubscriptionRepository;
import com.pecanha.events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class SubscriptionService {

    @Autowired
    private EventRepository evtRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SubscriptionRepository subRepo;
    @Autowired
    private UserRepository userRepository;

    public SubscriptionResponse CreateNewSubscription(String eventName, User user, Integer userId){
        Event evt = evtRepo.findByPrettyName(eventName);
        if (evt == null){
            throw new EventNotFoundException("Evento " + eventName+ " não existe");
        }
        User userRec = userRepo.findByUserEmail(user.getUserEmail());
        if(userRec == null){
            userRec = userRepo.save(user);
        }

        User indicador = null;
        if(userId != null){
            indicador = userRepository.findById(userId).orElse(null);
            if (indicador == null) {
                throw new UserIndicadorNotFoundException("Usuário " +userId+ " indicador não existe");
            }
        }

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(userRec);
        subs.setIndication(indicador);

        Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
        if(tmpSub != null){
            throw new SubscriptionConflictException("Já existe inscrição para o usuário " + userRec.getUserName() + " no evento " + evt.getTitle());
        }

        Subscription res = subRepo.save(subs);
        return new SubscriptionResponse(res.getSubscriptionNumber(), "http://centraldeeventos/subscription/"+res.getEvent().getPrettyName()+"/"+res.getSubscriber().getUserId());
    }

    public List<SubscriptionRankingItem> getCompleteRanking(String prettyName){
        Event evt = evtRepo.findByPrettyName(prettyName);
        if(evt == null){
            throw new EventNotFoundException("Ranking do evento "+ prettyName + " não existe");
        }
        return subRepo.generateRanking(evt.getEventId());
    }

    public SubscriptionRankingByUser getRankingByUser(String prettyName, Integer userId){
        List<SubscriptionRankingItem> ranking = getCompleteRanking(prettyName);
        SubscriptionRankingItem item = ranking.stream().filter(i->i.userId().equals(userId)).findFirst().orElse(null);
        if(item == null){
            throw new UserIndicadorNotFoundException("Não há inscrições com indicação do usuário "+userId);
        }
        Integer posicao = IntStream.range(0, ranking.size()).filter(pos -> ranking.get(pos).userId().equals(userId)).findFirst().getAsInt();
        return new SubscriptionRankingByUser(item, posicao+1);
    }

}
