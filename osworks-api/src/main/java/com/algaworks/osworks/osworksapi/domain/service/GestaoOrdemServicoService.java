package com.algaworks.osworks.osworksapi.domain.service;

import com.algaworks.osworks.osworksapi.domain.exception.NegocioException;
import com.algaworks.osworks.osworksapi.domain.model.Cliente;
import com.algaworks.osworks.osworksapi.domain.model.OrdemServico;
import com.algaworks.osworks.osworksapi.domain.model.StatusOrdemServico;
import com.algaworks.osworks.osworksapi.domain.repository.ClienteRepository;
import com.algaworks.osworks.osworksapi.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public OrdemServico criar(OrdemServico ordemServico) {
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
        
        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    }
}