package cc.mrbird.febs.blog.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author MrBird
 * @date 2019-10-08 13:23:19
 */
@Data
@TableName("b_user")
public class BUser {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("name")
    private String name;

    /**
     * 
     */
    @TableField("username")
    private String username;

    /**
     * 
     */
    @TableField("email")
    private String email;

    /**
     * 
     */
    @TableField("address_street")
    private String addressStreet;

    /**
     * 
     */
    @TableField("address_suite")
    private String addressSuite;

    /**
     * 
     */
    @TableField("address_city")
    private String addressCity;

    /**
     * 
     */
    @TableField("address_zipcode")
    private String addressZipcode;

    /**
     * 
     */
    @TableField("address_geo_lat")
    private String addressGeoLat;

    /**
     * 
     */
    @TableField("address_geo_lng")
    private String addressGeoLng;

    /**
     * 
     */
    @TableField("phone")
    private String phone;

    /**
     * 
     */
    @TableField("website")
    private String website;

    /**
     * 
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 
     */
    @TableField("company_catch_phrase")
    private String companyCatchPhrase;

    /**
     * 
     */
    @TableField("company_bs")
    private String companyBs;

}
