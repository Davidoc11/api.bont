package com.naat.bontu.api.bontu.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author David
 */
@AllArgsConstructor
@Data
public class CreditsResponse {
    
private List<Credit> credits;
}
