package io.github.pj.cattletraceabilitybackendsss.controller;

import io.github.pj.cattletraceabilitybackendsss.entity.Cattle;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.CattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cattle")
public class CattleController {

    @Autowired
    private CattleService cattleService;

    @PostMapping
    public ResponseEntity<?> addCattle(@RequestBody CattleRequest request) {
        Cattle cattle = new Cattle();
        // 设置牛只属性
        cattleService.add(cattle);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCattleDetails(@PathVariable Integer id) {
        Cattle cattle = cattleService.getCattleById(id);
        return ResponseEntity.ok(cattle);
    }

    @PutMapping("/{id}/slaughter")
    public ResponseEntity<?> slaughterCattle(@PathVariable Integer id) {
        Cattle cattle = cattleService.getCattleById(id);
        cattle.setSlaughterTime(LocalDateTime.now());
        cattleService.updateSlaughterTime(cattle);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> listCattle() {
        List<Cattle> cattleList = cattleService.list();
        return ResponseEntity.ok(cattleList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCattle(@PathVariable Integer id) {
        cattleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
/*
CattleController包含以下几个方法:
addCattle: 添加新的牛只,调用cattleService的add方法
getCattleDetails: 获取指定ID的牛只详情,调用cattleService的getCattleById方法
slaughterCattle: 更新指定ID的牛只的屠宰时间,调用cattleService的updateSlaughterTime方法
listCattle: 获取所有牛只列表,调用cattleService的list方法
deleteCattle: 删除指定ID的牛只,调用cattleService的delete方法*/
