@Repository
public interface DeliveryMethodsRepository extends JpaRepository<DeliveryMethods, Long> {

    DeliveryMethods findByEmail(String email);

    DeliveryMethods findByFtpUrl(String ftpUrl);

    DeliveryMethods findBySharepointUrl(String sharepointUrl);

    DeliveryMethods findByDeliverySchedule(String deliverySchedule);

    DeliveryMethods findByFileTypeTransformation(String fileTypeTransformation);

    DeliveryMethods findBySuccessNotifications(String successNotifications);

}