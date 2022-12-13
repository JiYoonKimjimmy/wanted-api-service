package me.jimmyberg.wanted.entity;

import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyRequest;
import me.jimmyberg.wanted.common.embeddable.Locale;
import me.jimmyberg.wanted.common.entity.BaseEntity;

import javax.persistence.*;

@Table(name = "COMPANIES")
@Entity
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Embedded
    private Locale locale;

    public static Company of(SaveCompanyRequest request) {
        Company entity = new Company();
        entity.setName(request.getName());
        entity.setLocale(request.getLocale());
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
