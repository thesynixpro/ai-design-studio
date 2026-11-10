package com.aprax.aidesignstudio.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GeneratedFile implements Parcelable {
    private String fileId;
    private String fileName;
    private String filePath;
    private String fileType; // html, css, js, xml, java, kt, json, yaml, txt, md
    private String content;
    private String language;
    private long size;
    private boolean isMainFile;
    private int order;

    public GeneratedFile() {
        this.fileId = java.util.UUID.randomUUID().toString();
    }

    protected GeneratedFile(Parcel in) {
        fileId = in.readString();
        fileName = in.readString();
        filePath = in.readString();
        fileType = in.readString();
        content = in.readString();
        language = in.readString();
        size = in.readLong();
        isMainFile = in.readByte() != 0;
        order = in.readInt();
    }

    public static final Creator<GeneratedFile> CREATOR = new Creator<GeneratedFile>() {
        @Override
        public GeneratedFile createFromParcel(Parcel in) {
            return new GeneratedFile(in);
        }

        @Override
        public GeneratedFile[] newArray(int size) {
            return new GeneratedFile[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fileId);
        dest.writeString(fileName);
        dest.writeString(filePath);
        dest.writeString(fileType);
        dest.writeString(content);
        dest.writeString(language);
        dest.writeLong(size);
        dest.writeByte(isMainFile ? (byte) 1 : (byte) 0);
        dest.writeInt(order);
    }

    public String getFileId() { return fileId; }
    public void setFileId(String id) { this.fileId = id; }
    public String getFileName() { return fileName; }
    public void setFileName(String name) { this.fileName = name; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String path) { this.filePath = path; }
    public String getFileType() { return fileType; }
    public void setFileType(String type) { this.fileType = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getLanguage() { return language; }
    public void setLanguage(String lang) { this.language = lang; }
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
    public boolean isMainFile() { return isMainFile; }
    public void setMainFile(boolean main) { this.isMainFile = main; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }

    @Override
    public String toString() {
        return "GeneratedFile{" + filePath + "/" + fileName + "}";
    }
}
