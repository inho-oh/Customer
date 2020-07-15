package usedbookstore;

import usedbookstore.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPurchased_then_CREATE_ (@Payload Purchased purchased) {
        try {
            if (purchased.isMe()) {
                // view 객체 생성
                MyPage myPage = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                myPage.setPurchaseid(purchased.getId());
                myPage.setPurchaseqty(purchased.getQty());
                myPage.setPurchasedate(purchased.getPurchasedate());
                myPage.setCustomerid(purchased.getCustomerid());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPurchaseCanceled_then_UPDATE_(@Payload PurchaseCanceled purchaseCanceled) {
        try {
            if (purchaseCanceled.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByPurchaseid(purchaseCanceled.getId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setCanceldate(purchaseCanceled.getCanceldate());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_(@Payload Delivered delivered) {
        try {
            if (delivered.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByPurchaseid(delivered.getPurchaseid());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setDeliveryid(delivered.getId());
                    myPage.setStatus(delivered.getStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancelled_then_UPDATE_(@Payload DeliveryCancelled deliveryCancelled) {
        try {
            if (deliveryCancelled.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByPurchaseid(deliveryCancelled.getPurchaseid());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setStatus(deliveryCancelled.getStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}