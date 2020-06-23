package akr.trainingmicro.msscbrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerDto {
	
	private UUID id;
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;
	

}
