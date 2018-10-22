package ua.stqa.pft.addressbook.Models;

import java.util.Objects;

public class AddressData {
    private int id;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String company;
    private  String address;
    private  String home;
    private  String mobile;
    private  String work;
    private  String fax;
    private  String email;
    private  String email2;
    private  String email3;
    private  String homepage;
    private  String address2;
    private  String phone2;
    private  String notes;
    private  String group;
    private  String allPhones;

    public String getAllPhones() {
        return allPhones;
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

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public AddressData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public AddressData withId(int max) {
        this.id = max;
        return this;
    }

    public AddressData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public AddressData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public AddressData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public AddressData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public AddressData withTitle(String title) {
        this.title = title;
        return this;
    }

    public AddressData withCompany(String company) {
        this.company = company;
        return this;
    }

    public AddressData withAddress(String address) {
        this.address = address;
        return this;
    }

    public AddressData withHome(String home) {
        this.home = home;
        return this;
    }

    public AddressData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public AddressData withWork(String work) {
        this.work = work;
        return this;
    }

    public AddressData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public AddressData withEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public AddressData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public AddressData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public AddressData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public AddressData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public AddressData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public AddressData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressData that = (AddressData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }
}
