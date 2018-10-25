package ua.stqa.pft.addressbook.Models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private  String firstname;

    @Transient
    private  String middlename;

    @Expose
    @Column(name = "lastname")
    private  String lastname;

    @Transient
    private  String nickname;

    @Transient
    private  String title;

    @Transient
    private  String company;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private  String address;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private  String home;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobile;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private  String work;

    @Transient
    private  String fax;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private  String email;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private  String email2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private  String email3;

    @Transient
    private  String homepage;

    @Transient
    private  String address2;

    @Transient
    private  String phone2;

    @Transient
    private  String notes;

    @Transient
    private  String allPhones;

    @Transient
    private  String allEmails;

    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private  String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(home, that.home) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(work, that.work) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, home, mobile, work, email, email2, email3);
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getWorkPhone() {
        return work;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getPhoto() {
        return photo;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                ", work='" + work + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", homepage='" + homepage + '\'' +
                ", address2='" + address2 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", notes='" + notes + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public ContactData withId(int max) {
        this.id = max;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
