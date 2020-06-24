package akr.trainingmicro.msscbrewery.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Customer {
	
	private UUID id;
	private String name;
	

}
