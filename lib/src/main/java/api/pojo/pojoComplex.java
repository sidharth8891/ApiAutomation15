package api.pojo;

import java.util.List;

public class pojoComplex {

    private String name; // this is for the name filed in pojo

    private List<String> jobs; // this is for jobs filed in pojo

    private List<cityModel> citymodels; //refer the city model class below, we have created separate pojo class for it as it is a list of map


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    public List<cityModel> getCitymodels() {
        return citymodels;
    }

    public void setCitymodels(List<cityModel> citymodels) {
        this.citymodels = citymodels;
    }

}
