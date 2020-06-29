package com.algaworks.osworks.osworksapi.api.model;

import javax.validation.constraints.NotNull;

class ClienteIdInput {
    
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
