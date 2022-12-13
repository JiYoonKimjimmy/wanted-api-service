package me.jimmyberg.wanted.common.enumerate;

public enum JobPostSortBy {

    ID("id"),
    COMPANY("company.name"),
    JOB_TYPE("jobType"),
    COUNTRY("country")
    ;

    private final String property;

    JobPostSortBy(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

}
