package student.management.spring.app.services;

public interface RegulationsService {
    public int getMinAge();
    public int getMaxAge();
    public double getPassScore();
    public void updateRegulation(String minAge, String maxAge, String passScore,String classCount);
    public int getClassCount();
}
