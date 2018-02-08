package com.mvc.console.mapper;

import com.mvc.console.dto.LockRecordDTO;
import com.mvc.console.entity.LockRecord;
import com.mvc.console.vo.LockRecordVO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author qyc
 */
public interface LockRecordMapper extends Mapper<LockRecord> {
    /**
     * list
     *
     * @param lockRecordDTO
     * @return
     */
    @Select("select * from lock_record where user_id = #{userId}")
    List<LockRecordVO> list(LockRecordDTO lockRecordDTO);
}