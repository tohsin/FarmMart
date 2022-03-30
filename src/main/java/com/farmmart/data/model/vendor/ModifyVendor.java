package com.farmmart.data.model.vendor;

import com.farmmart.data.model.staticdata.Facility;
import com.farmmart.data.model.staticdata.MeansOfIdentification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyVendor {

    private Long id;

    private String representative;

    private MeansOfIdentification meansOfIdentification;

    private String meansOfIdNumber;

    private LocalDate meansOfIdIssueDate;

    private LocalDate meansOfIdExpiryDate;

    private Facility facility;

}
