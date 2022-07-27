package com.bank.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 1111111111111
 * 2222222222222
 * 3333333333333
 * 4444444444444
 */
@Data
@TableName("acount")
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    private String name;

    private BigDecimal money;
}
