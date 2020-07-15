package usedbookstore;

import usedbookstore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired CustomerRepository customerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSold_PointSave(@Payload Sold sold){

        if(sold.isMe()){
            Customer customer = null;
            Optional<Customer> optional = customerRepository.findById(sold.getCustomerid());
            if (optional.isPresent()) {
                customer = optional.get();
                customer.setId(sold.getCustomerid());
                customer.setPoint(customer.getPoint().longValue() + sold.getPoint());
                customer.setUsecnt(customer.getUsecnt().longValue() + 1);
                if(customer.getUsecnt() > 3 && customer.getUsecnt() < 5) {
                    customer.setGrade("B");
                }else
                if(customer.getUsecnt() > 10) {
                    customer.setGrade("A");
                } else
                    customer.setGrade("C");

                customerRepository.save(customer);
                System.out.println("##### listener wheneverSold_PointSave : " + sold.toJson());
            } else
                System.out.println("##### listener wheneverSold_PointSave : null ");
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPurchased_PointSave(@Payload Purchased purchased){

        if(purchased.isMe()){
            Customer customer = null;
            Optional<Customer> optional = customerRepository.findById(purchased.getCustomerid());
            if (optional.isPresent()) {
                customer = optional.get();
                customer.setId(purchased.getCustomerid());
                customer.setPoint(customer.getPoint().longValue() + purchased.getPoint());
                customer.setUsecnt(customer.getUsecnt().longValue() + 1);
                System.out.println("##### listener wheneverSold_Usage : " + customer.getUsecnt());
                if(customer.getUsecnt() > 3 && customer.getUsecnt() < 5) {
                    customer.setGrade("B");
                }else
                if(customer.getUsecnt() > 10) {
                    customer.setGrade("A");
                } else
                    customer.setGrade("C");

                customerRepository.save(customer);
                System.out.println("##### listener wheneverPurchaseCanceled_PointSave : " + purchased.toJson());
            } else
                System.out.println("##### listener wheneverPurchaseCanceled_PointSave : null ");
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSold_Usage(@Payload Sold sold){

        if(sold.isMe()){
//            Customer customer = null;
//            Optional<Customer> optional = customerRepository.findById(sold.getCustomerid());
//            System.out.println("##### listener wheneverSold_Usage : " + optional.get());
//            if (optional.isPresent()) {
//                customer = optional.get();
//                customer.setId(sold.getCustomerid());
//                customer.setUsecnt(customer.getUsecnt().longValue() + 1);
//
//                if(customer.getUsecnt() > 3 && customer.getUsecnt() < 5) {
//                    customer.setGrade("B");
//                }else
//                    if(customer.getUsecnt() > 10) {
//                        customer.setGrade("A");
//                    } else
//                        customer.setGrade("C");
//
//                customerRepository.save(customer);
//                System.out.println("##### listener wheneverSold_Usage : " + sold.toJson());
//            } else
//                System.out.println("##### listener wheneverSold_Usage : null ");
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPurchased_Usage(@Payload Purchased purchased){

        if(purchased.isMe()){
//            Customer customer = null;
//            Optional<Customer> optional = customerRepository.findById(purchased.getCustomerid());
//            System.out.println("##### listener wheneverSold_Usage : " + optional.get());
//            if (optional.isPresent()) {
//                customer = optional.get();
//                customer.setId(purchased.getCustomerid());
//                System.out.println("##### listener usecnt : " + customer.getUsecnt().longValue());
//                customer.setUsecnt(customer.getUsecnt().longValue() + 1);
//                if(customer.getUsecnt() > 3 && customer.getUsecnt() < 5) {
//                    customer.setGrade("B");
//                }else
//                    if(customer.getUsecnt() > 10) {
//                        customer.setGrade("A");
//                    } else
//                        customer.setGrade("C");
//
//                customerRepository.save(customer);
//                System.out.println("##### listener wheneverPurchased_Usage : " + purchased.toJson());
//            } else
//                System.out.println("##### listener wheneverPurchased_Usage : null ");
        }
    }

}
