package es.ulpgc.dis.model;

public class Image {
    public final byte[] content;

    public Image(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }
}
