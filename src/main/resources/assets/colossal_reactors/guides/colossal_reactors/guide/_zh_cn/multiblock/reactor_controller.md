---
navigation:
  parent: multiblock/multiblock-index.md
  title: 反应堆控制器
  icon: reactor_controller
  position: 20
item_ids:
  - colossal_reactors:reactor_controller
categories:
  - multiblock
---

# 反应堆控制器

<BlockImage id="reactor_controller" scale="4" />

反应堆控制器需要紧贴在反应堆外壳**侧面**（不接受上下）并朝向外侧。**右键点击**控制器可打开 GUI。

刚开始游玩模组？建议先阅读[入门指南](colossal_reactors:multiblock/getting_started.md)。

## 功能

- **验证 / 运行**：首次打开控制器会验证结结构，验证完成后反应堆即可启动并显示产能、燃料和冷却剂数据；
- **燃料**：在相应槽位显示时在物品栏和燃料棒存储中转移燃料；
- **冷却剂流体**：显示冷却剂储量，并在提供了控制功能时装填 / 提取冷却剂（在**仅发电**且冷却剂全空时作为可选功能）；
- **重启**：在重新验证反应堆结构 — re-validates the structure and refreshes port tank sizes after you change the build or port settings.

## 在不破坏结构的情况下停机

若需要关停反应堆且不破坏结构，可以使用[反应堆红石接口](redstone_port.md)进行外部红石控制。**不使用**红石接口时反应堆会在结构合适时一直**保持开启**。

若整合包启用了**稳定性**，则稳定性也会在控制器中显示，参见[反应堆稳定性](reactor_instability.md).

## 反应堆合法但是不产能

| 检查项目 | |
|-------|---|
| 是否存在连接了线缆的能量端口 | RF 需要外侧连接了能量接收装置的[能量端口](power_ports.md) 才能产生 |
| 是否处于仅产能模式 | 纯产能模式不需要冷却剂，水 / 蒸汽模式需要冷却剂和相应回路 |
| 检查红石端口 | 反应堆在红石端口模式和红石信号组合不允许运行时会停机 |
| 核废料堆积 | 添加一个**提取**[资源端口](resource_port.md)或手动清空核废料 |

控制器界面中“状态”一栏的说明表示反应堆现在的状态。
