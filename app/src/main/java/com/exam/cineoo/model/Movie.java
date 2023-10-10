package com.exam.cineoo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("movieCode")
    @Expose
    private List<String> movieCode;
    @SerializedName("title_en")
    @Expose
    private String titleEn;
    @SerializedName("title_th")
    @Expose
    private String titleTh;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rating_id")
    @Expose
    private Integer ratingId;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("sneak_date")
    @Expose
    private String sneakDate;
    @SerializedName("synopsis_th")
    @Expose
    private String synopsisTh;
    @SerializedName("synopsis_en")
    @Expose
    private String synopsisEn;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("actor")
    @Expose
    private String actor;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("poster_ori")
    @Expose
    private String posterOri;
    @SerializedName("poster_url")
    @Expose
    private String posterUrl;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("tr_ios")
    @Expose
    private String trIos;
    @SerializedName("tr_hd")
    @Expose
    private String trHd;
    @SerializedName("tr_sd")
    @Expose
    private String trSd;
    @SerializedName("tr_mp4")
    @Expose
    private String trMp4;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("now_showing")
    @Expose
    private String nowShowing;
    @SerializedName("advance_ticket")
    @Expose
    private String advanceTicket;
    @SerializedName("date_update")
    @Expose
    private String dateUpdate;
    @SerializedName("show_buyticket")
    @Expose
    private String showBuyticket;
    @SerializedName("trailer_cms_id")
    @Expose
    private String trailerCmsId;
    @SerializedName("trailer_ivx_key")
    @Expose
    private String trailerIvxKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(List<String> movieCode) {
        this.movieCode = movieCode;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleTh() {
        return titleTh;
    }

    public void setTitleTh(String titleTh) {
        this.titleTh = titleTh;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSneakDate() {
        return sneakDate;
    }

    public void setSneakDate(String sneakDate) {
        this.sneakDate = sneakDate;
    }

    public String getSynopsisTh() {
        return synopsisTh;
    }

    public void setSynopsisTh(String synopsisTh) {
        this.synopsisTh = synopsisTh;
    }

    public String getSynopsisEn() {
        return synopsisEn;
    }

    public void setSynopsisEn(String synopsisEn) {
        this.synopsisEn = synopsisEn;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPosterOri() {
        return posterOri;
    }

    public void setPosterOri(String posterOri) {
        this.posterOri = posterOri;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTrIos() {
        return trIos;
    }

    public void setTrIos(String trIos) {
        this.trIos = trIos;
    }

    public String getTrHd() {
        return trHd;
    }

    public void setTrHd(String trHd) {
        this.trHd = trHd;
    }

    public String getTrSd() {
        return trSd;
    }

    public void setTrSd(String trSd) {
        this.trSd = trSd;
    }

    public String getTrMp4() {
        return trMp4;
    }

    public void setTrMp4(String trMp4) {
        this.trMp4 = trMp4;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNowShowing() {
        return nowShowing;
    }

    public void setNowShowing(String nowShowing) {
        this.nowShowing = nowShowing;
    }

    public String getAdvanceTicket() {
        return advanceTicket;
    }

    public void setAdvanceTicket(String advanceTicket) {
        this.advanceTicket = advanceTicket;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getShowBuyticket() {
        return showBuyticket;
    }

    public void setShowBuyticket(String showBuyticket) {
        this.showBuyticket = showBuyticket;
    }

    public String getTrailerCmsId() {
        return trailerCmsId;
    }

    public void setTrailerCmsId(String trailerCmsId) {
        this.trailerCmsId = trailerCmsId;
    }

    public String getTrailerIvxKey() {
        return trailerIvxKey;
    }

    public void setTrailerIvxKey(String trailerIvxKey) {
        this.trailerIvxKey = trailerIvxKey;
    }

}
