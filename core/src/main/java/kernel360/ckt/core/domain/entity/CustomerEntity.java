package kernel360.ckt.core.domain.entity;

import jakarta.persistence.*;
import kernel360.ckt.core.domain.enums.CustomerStatus;
import kernel360.ckt.core.domain.enums.CustomerType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customer")
@Entity
public class CustomerEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

    @Column(nullable = false)
    private String email;

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    private String zipCode;
    private String address;
    private String detailedAddress;
    private String birthday;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "delete_yn", nullable = false, length = 1, columnDefinition = "CHAR(1)")
    private String deleteYn = "N";

    public CustomerEntity(CustomerType customerType,
                          String email,
                          String customerName,
                          String phoneNumber,
                          String licenseNumber,
                          String zipCode,
                          String address,
                          String detailedAddress,
                          String birthday,
                          CustomerStatus status,
                          Long companyId) {
        this.customerType = customerType;
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.zipCode = zipCode;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.birthday = birthday;
        this.status = status;
        this.companyId = companyId;
    }

    public static CustomerEntity create(
        CustomerType customerType,
        String email,
        String customerName,
        String phoneNumber,
        String licenseNumber,
        String zipCode,
        String address,
        String detailedAddress,
        String birthday,
        CustomerStatus status,
        Long companyId
    ) {
        return new CustomerEntity(
            customerType,
            email,
            customerName,
            phoneNumber,
            licenseNumber,
            zipCode,
            address,
            detailedAddress,
            birthday,
            status,
            companyId
        );
    }

    public void updateBasicInfo(CustomerType customerType,
                                String email,
                                String customerName,
                                String phoneNumber,
                                String licenseNumber,
                                String zipCode,
                                CustomerStatus status,
                                String address,
                                String detailedAddress,
                                String birthday) {
        this.customerType = customerType;
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.zipCode = zipCode;
        this.status = status;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.birthday = birthday;
    }

    public void markAsDeleted() {
        this.deleteYn = "Y";
    }
}
