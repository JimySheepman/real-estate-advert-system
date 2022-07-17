package com.example.reportservice.consumer;

import com.example.reportservice.dto.ConsumerReceiveMessageDTO;
import com.example.reportservice.mapper.ReportModelMapper;
import com.example.reportservice.model.Report;
import com.example.reportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportConsumer {

    private final ReportModelMapper reportModelMapper;

    private final ReportRepository reportRepository;

    @RabbitListener(queues = "advert-queue")
    public void handleMessage(ConsumerReceiveMessageDTO consumerReceiveMessageDTO){
        System.out.println("Message received: "+consumerReceiveMessageDTO.toString());

        Report report = reportModelMapper.toReport(consumerReceiveMessageDTO);
        reportRepository.save(report);
    }
}
