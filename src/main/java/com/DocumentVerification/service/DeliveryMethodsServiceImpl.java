@Service
public class DeliveryMethodsServiceImpl implements DeliveryMethodsService {

    private final DeliveryMethodsRepository deliveryMethodsRepository;

    public DeliveryMethodsServiceImpl(DeliveryMethodsRepository deliveryMethodsRepository) {
        this.deliveryMethodsRepository = deliveryMethodsRepository;
    }

    @Override
    public DeliveryMethods findByEmail(String email) {
        return deliveryMethodsRepository.findByEmail(email);
    }

    @Override
    public DeliveryMethods findByFtpUrl(String ftpUrl) {
        return deliveryMethodsRepository.findByFtpUrl(ftpUrl);
    }

    @Override
    public DeliveryMethods findBySharepointUrl(String sharepointUrl) {
        return deliveryMethodsRepository.findBySharepointUrl(sharepointUrl);
    }

    @Override
    public DeliveryMethods findByDeliverySchedule(String deliverySchedule) {
        return deliveryMethodsRepository.findByDeliverySchedule(deliverySchedule);
    }

    @Override
    public DeliveryMethods findByFileTypeTransformation(String fileTypeTransformation) {
        return deliveryMethodsRepository.findByFileTypeTransformation(fileTypeTransformation);
    }

    @Override
    public DeliveryMethods findBySuccessNotifications(String successNotifications) {
        return deliveryMethodsRepository.findBySuccessNotifications(successNotifications);
    }

    @Override
    public DeliveryMethods saveDeliveryMethods(DeliveryMethods deliveryMethods) {
        return deliveryMethodsRepository.save(deliveryMethods);
    }

    @Override
    public void deleteDeliveryMethods(DeliveryMethods deliveryMethods) {
        deliveryMethodsRepository.delete(deliveryMethods);
    }

    @Override
    public void scheduleReport(String fileType, String destination, String frequency) {
        //TODO: Implement scheduling logic
    }

    @Override
    public void createFolders(String filePath) {
        //TODO: Implement folder creation logic
    }
}