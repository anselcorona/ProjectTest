package com.example.anselcorona2.projecttest.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class Card implements  Parcelable {

    private String tipo;
    private String title;
    private String body;
    private String nivel;
    private ArrayList<Boolean> redes;
    private Date fecha;
    private Author author;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Boolean> getRedes() {
        return redes;
    }

    public void setRedes(ArrayList<Boolean> redes) {
        this.redes = redes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card(String tipo, String title, String body, String nivel, ArrayList<Boolean> redes, Date fecha, Author author) {

        this.tipo = tipo;
        this.title = title;
        this.body = body;
        this.nivel = nivel;
        this.redes = redes;
        this.fecha = fecha;
        this.author = author;
    }

    protected Card(Parcel in) {
        tipo = in.readString();
        title = in.readString();
        body = in.readString();
        nivel = in.readString();
        if (in.readByte() == 0x01) {
            redes = new ArrayList<Boolean>();
            in.readList(redes, Boolean.class.getClassLoader());
        } else {
            redes = null;
        }
        long tmpFecha = in.readLong();
        fecha = tmpFecha != -1 ? new Date(tmpFecha) : null;
        author = (Author) in.readValue(Author.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipo);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(nivel);
        if (redes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(redes);
        }
        dest.writeLong(fecha != null ? fecha.getTime() : -1L);
        dest.writeValue(author);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}