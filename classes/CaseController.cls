public class CaseController {
    // Case management controller for Service Cloud
    // Handles case creation, routing, and automation
    
    @AuraEnabled
    public static Case createCase(String subject, String description, String priority) {
        Case newCase = new Case(
            Subject = subject,
            Description = description,
            Priority = priority,
            Status = 'New',
            Origin = 'Web'
        );
        insert newCase;
        return newCase;
    }
    
    @AuraEnabled
    public static List<Case> getOpenCases() {
        return [SELECT Id, Subject, Status, Priority, CreatedDate 
                FROM Case 
                WHERE Status != 'Closed' 
                ORDER BY CreatedDate DESC];
    }
}
