//package com.example.myhealthblock.api.healthdata;
//
//import com.example.myhealthblock.api.healthdata.dto.request.BlockchainTransactionRequestDTO;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Component
//public class BlockchainClient {
//    private final WebClient webClient;
//    private final String socketAddress = "localhost:5000";
//
//    public BlockchainClient() {
//        this.webClient = WebClient.create("http://" + socketAddress + "/");
//    }
//
//    public Mono<String> registerHash(String data_hash) {
//        String contract_code = String.format("def store_hash():\n    return '%s'", data_hash);
//
//        BlockchainTransactionRequestDTO requestDTO = new BlockchainTransactionRequestDTO();
//        requestDTO.setSender("server");
//        requestDTO.setRecipient("blockChain_server");
//        requestDTO.setAmount(0);
//        requestDTO.setSmart_contract(new BlockchainTransactionRequestDTO.SmartContract(contract_code));
//
//        return webClient.post()
//                .uri("/transactions/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(requestDTO))
//                .retrieve()
//                .bodyToMono(BlockchainTransactionResponseDTO.class)
//                .map(BlockchainTransactionResponseDTO::getContractAddress);
//    }
//}