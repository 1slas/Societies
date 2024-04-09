package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.DTO.InformationDTO;
import com.ethereal.pojo.Information;
import com.ethereal.service.InformationService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-29  08:40
 * @Description: 信息控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("/information")
public class InformationController {

    @Resource
    private InformationService informationService;
    /**
     * @param information:
      * @return Result
     * @author 53609
     * @description 新增社团资讯
     * @date 2024/3/29 8:49
     */
    @PostMapping
    public Result add(@RequestBody Information information){
        informationService.add(information);
        return Result.success();
    }
    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 删除社团资讯
     * @date 2024/3/29 8:52
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        informationService.deleteById(id);
        return Result.success();
    }
    /**
     * @param ids:
      * @return Result
     * @author 53609
     * @description 批量删除社团资讯
     * @date 2024/3/29 8:55
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        informationService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * @param information:
      * @return Result
     * @author 53609
     * @description 修改社团资讯
     * @date 2024/3/29 8:58
     */
    @PutMapping
    public Result updateById(@RequestBody Information information){
        informationService.updateById(information);
        return Result.success();
    }
    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 根据id查询
     * @date 2024/3/29 9:01
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        InformationDTO informationDTO = informationService.selectById(id);
        return Result.success(informationDTO);
    }
    /**
     * @param informationDTO:
      * @return Result
     * @author 53609
     * @description 获取信息列表
     * @date 2024/3/29 9:57
     */
    @GetMapping("/selectAll")
    public Result selectById(@RequestBody InformationDTO informationDTO){
        List<InformationDTO> list = informationService.selectAll(informationDTO);
        return Result.success(list);
    }
    /**
     * @param informationDTO:
    	 * @param pageNum:
    	 * @param pageSize:
      * @return Result
     * @author 53609
     * @description 分页查询
     * @date 2024/3/29 10:01
     */
    @GetMapping("/selectPage")
    public Result selectPage(InformationDTO informationDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "2") Integer pageSize){
        PageInfo<InformationDTO> page = informationService.selectPage(informationDTO,pageNum,pageSize);
        return Result.success(page);
    }

}
