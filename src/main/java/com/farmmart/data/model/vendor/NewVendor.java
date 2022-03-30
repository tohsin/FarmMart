package com.farmmart.data.model.vendor;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.staticdata.BusinessEntity;
import com.farmmart.data.model.staticdata.Facility;
import com.farmmart.data.model.staticdata.MeansOfIdentification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewVendor {

    private BusinessEntity businessEntity;

    private String name;

    private String rcNumber;

    private String taxId;

    private String natureOfBusiness;

    private MeansOfIdentification meansOfIdentification;

    private String meansOfIdNumber;

    private LocalDate meansOfIdIssueDate;

    private LocalDate meansOfIdExpiryDate;

    private String representative;

    private Facility facility;

    private AppUser appUser;
}
