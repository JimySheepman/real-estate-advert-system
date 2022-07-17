package com.example.reportservice.consumer;

import com.example.reportservice.dto.ConsumerReceiveMessageDTO;
import com.example.reportservice.mapper.ReportModelMapper;
import com.example.reportservice.model.Report;
import com.example.reportservice.repository.ReportRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportConsumer {

    private final ReportModelMapper reportModelMapper;

    private final ReportRepository reportRepository;

    private static final Gson gson = new Gson();

    @RabbitListener(queues = "advert-queue")
    public void handleMessage(String message){
        ConsumerReceiveMessageDTO dto = gson.fromJson(message, ConsumerReceiveMessageDTO.class);
        System.out.println("Message received: "+message);

        Report report = reportModelMapper.toReport(dto);
        reportRepository.save(report);
    }
}
