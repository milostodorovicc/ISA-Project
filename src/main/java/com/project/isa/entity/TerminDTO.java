package com.project.isa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TerminDTO {
    private String imekorisnikarez;
    private String prezimekorisnikarez;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public String getImekorisnikarez() {
        return imekorisnikarez;
    }

    public void setImekorisnikarez(String imekorisnikarez) {
        this.imekorisnikarez = imekorisnikarez;
    }

    public String getPrezimekorisnikarez() {
        return prezimekorisnikarez;
    }

    public void setPrezimekorisnikarez(String prezimekorisnikarez) {
        this.prezimekorisnikarez = prezimekorisnikarez;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }



    public TerminDTO() {
    }

    public TerminDTO(String imekorisnikarez, String prezimekorisnikarez, LocalDateTime startTime, LocalDateTime endTime) {
        this.imekorisnikarez = imekorisnikarez;
        this.prezimekorisnikarez = prezimekorisnikarez;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
