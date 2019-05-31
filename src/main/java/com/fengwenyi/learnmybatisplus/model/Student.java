package com.fengwenyi.learnmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fengwenyi.learnmybatisplus.enums.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_student")
@ApiModel(value="Student对象", description="")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识，主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "介绍")
    private String info;

    @ApiModelProperty(value = "是否逻辑删除（true：删除；false：正常（默认））")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "性别（0：保密（默认）；1：男；2：女）")
    private GenderEnum gender;

    @ApiModelProperty(value = "身份证号码表编号（id）")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long idcardId;

    @ApiModelProperty(value = "城市表编号（id）")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long cityId;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AGE = "age";

    public static final String INFO = "info";

    public static final String IS_DELETE = "is_delete";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String GENDER = "gender";

    public static final String IDCARD_ID = "idcard_id";

    public static final String CITY_ID = "city_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
