package com.simon.model;

import com.simon.common.utils.SnowflakeGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* @author SimonSun
* @create 2018-09-12
**/
@ApiModel(value = "权限")
@Data
@Entity
@Table(name="t_authorities")
public class Authority implements GrantedAuthority, Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(genId = SnowflakeGenId.class)
    @GeneratedValue(generator = "sequenceId")
    @GenericGenerator(name = "sequenceId", strategy = "com.simon.common.utils.snowflake.SequenceId")
    private Long id;

    @ApiModelProperty(value = "创建人id")
    @Column(name = "create_by")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新人id")
    @Column(name = "update_by")
    private Long updateBy;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_date")
    private Date updateDate;

    @ApiModelProperty(value = "用户id")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ApiModelProperty(value = "权限")
    @Column(name = "authority", nullable = false)
    private String authority;
}