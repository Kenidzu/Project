package Project;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationtype;
    private city city;
    private flight flight;
    private aicraft aicraft;
    private ticket ticket;

    public PackageData( Project.city city, Project.flight flight, Project.aicraft aicraft) {
        this.city = city;
        this.flight = flight;
        this.aicraft = aicraft;
    }

    public PackageData(String operationtype) {
        this.operationtype = operationtype;
    }

    public PackageData() {
    }

    public Project.ticket getTicket() {
        return ticket;
    }

    public void setTicket(Project.ticket ticket) {
        this.ticket = ticket;
    }

    public PackageData(String operationtype, Project.ticket ticket) {
        this.operationtype = operationtype;
        this.ticket = ticket;
    }

    public PackageData(String operationtype, Project.city city) {
        this.operationtype = operationtype;
        this.city = city;
    }

    public PackageData(String operationtype, Project.flight flight) {
        this.operationtype = operationtype;
        this.flight = flight;
    }

    public PackageData(String operationtype, Project.aicraft aicraft) {
        this.operationtype = operationtype;
        this.aicraft = aicraft;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public Project.city getCity() {
        return city;
    }

    public void setCity(Project.city city) {
        this.city = city;
    }

    public Project.flight getFlight() {
        return flight;
    }

    public void setFlight(Project.flight flight) {
        this.flight = flight;
    }

    public Project.aicraft getAicraft() {
        return aicraft;
    }

    public void setAicraft(Project.aicraft aicraft) {
        this.aicraft = aicraft;
    }
}
