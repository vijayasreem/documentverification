@RestController
@RequestMapping(value = "/document-verification")
public class DeliveryMethodsController {

    private final DeliveryMethodsService deliveryMethodsService;

    public DeliveryMethodsController(DeliveryMethodsService deliveryMethodsService) {
        this.deliveryMethodsService = deliveryMethodsService;
    }

    @PostMapping("/delivery-methods")
    public DeliveryMethods saveDeliveryMethods(@RequestBody DeliveryMethods deliveryMethods){
        return deliveryMethodsService.saveDeliveryMethods(deliveryMethods);
    }

    @DeleteMapping("/delivery-methods")
    public void deleteDeliveryMethods(@RequestBody DeliveryMethods deliveryMethods){
        deliveryMethodsService.deleteDeliveryMethods(deliveryMethods);
    }

    @GetMapping("/delivery-methods/by-email")
    public DeliveryMethods getDeliveryMethodsByEmail(@RequestParam String email){
        return deliveryMethodsService.findByEmail(email);
    }

    @GetMapping("/delivery-methods/by-ftp-url")
    public DeliveryMethods getDeliveryMethodsByFtpUrl(@RequestParam String ftpUrl){
        return deliveryMethodsService.findByFtpUrl(ftpUrl);
    }

    @GetMapping("/delivery-methods/by-sharepoint-url")
    public DeliveryMethods getDeliveryMethodsBySharepointUrl(@RequestParam String sharepointUrl){
        return deliveryMethodsService.findBySharepointUrl(sharepointUrl);
    }

    @GetMapping("/delivery-methods/by-delivery-schedule")
    public DeliveryMethods getDeliveryMethodsByDeliverySchedule(@RequestParam String deliverySchedule){
        return deliveryMethodsService.findByDeliverySchedule(deliverySchedule);
    }

    @GetMapping("/delivery-methods/by-file-type-transformation")
    public DeliveryMethods getDeliveryMethodsByFileTypeTransformation(@RequestParam String fileTypeTransformation){
        return deliveryMethodsService.findByFileTypeTransformation(fileTypeTransformation);
    }

    @GetMapping("/delivery-methods/by-success-notifications")
    public DeliveryMethods getDeliveryMethodsBySuccessNotifications(@RequestParam String successNotifications){
        return deliveryMethodsService.findBySuccessNotifications(successNotifications);
    }

    @PostMapping("/schedule-report")
    public void scheduleReport(@RequestParam String fileType,
                               @RequestParam String destination,
                               @RequestParam String frequency){
        deliveryMethodsService.scheduleReport(fileType, destination, frequency);
    }

    @PostMapping("/create-folder")
    public void createFolders(@RequestParam String filePath){
        deliveryMethodsService.createFolders(filePath);
    }

}