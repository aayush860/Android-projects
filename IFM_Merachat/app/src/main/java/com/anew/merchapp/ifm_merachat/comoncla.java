package com.anew.merchapp.ifm_merachat;

/**
 * Created by new on 17-03-2018.
 */

public class comoncla {
    String uname;
    String psswrrd;
    String linkx;

    public comoncla(String uname, String psswrrd, String linkx) {
        this.uname = uname;
        this.psswrrd = psswrrd;
        this.linkx = linkx;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsswrrd() {
        return psswrrd;
    }

    public void setPsswrrd(String psswrrd) {
        this.psswrrd = psswrrd;
    }

    public String getLinkx() {
        return linkx;
    }

    public void setLinkx(String linkx) {
        this.linkx = linkx;
    }
}
