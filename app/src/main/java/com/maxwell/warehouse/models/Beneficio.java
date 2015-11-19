package com.maxwell.warehouse.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.maxwell.warehouse.utils.enums.InformationTypeEnum;

/**
 * Created by lbais on 20/08/2015.
 */
public class Beneficio extends Information implements Parcelable {

    private String benefitText;
    private String brandName;
    private String benefitPhoto;
    private Long expiration_date = 0L;

    public boolean big;

    public Beneficio(){

        defineViewType();
    }

    public Beneficio(String brandName, String benefitText, boolean size){

        this.brandName = brandName;
        this.benefitText = benefitText;
        this.big = size;

        defineViewType();
    }

    @Override
    public void defineViewType() {
        InformationTypeEnum result;

        if(!big){
            result = InformationTypeEnum.CARD_BENEFIT_WITH_DISTANCE;
        }
        else{
            result = InformationTypeEnum.CARD_BENEFIT_BIG;
        }

        this.setViewType(result.getViewTypeId());
    }



    public String getBenefitText() {
        return benefitText;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBenefitPhoto(){
        return benefitPhoto;
    }

    public void setBenefitPhoto(String benefitPhoto){
        this.benefitPhoto = benefitPhoto;
    }

    public Long getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Long expiration_date) {
        this.expiration_date = expiration_date;
    }

    public static Creator<Beneficio> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brandName);
    }

    public static final Creator<Beneficio> CREATOR = new Creator<Beneficio>() {
        public Beneficio createFromParcel(Parcel source) {
            Beneficio mBeneficio = new Beneficio();
            mBeneficio.setBrandName(source.readString());
            return mBeneficio;
        }
        public Beneficio[] newArray(int size) {
            return new Beneficio[size];
        }
    };

}
