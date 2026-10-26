---
navigation:
  parent: multiblock/multiblock-index.md
  title: 反应堆建造器
  icon: reactor_builder
  position: 30
item_ids:
  - colossal_reactors:reactor_builder
categories:
  - multiblock
---

# 反应堆建造器

<BlockImage id="reactor_builder" scale="4" />

**反应堆建造器**可以使用内部材料建造**反应堆外壳和内部**。其不会放置**反应堆控制器**、**能量接口**和**资源接口**，参见[入门指南](getting_started.md).

## 建造器建造顺序

1. **外壳**（可选择**顶部开放**以便后续修改）
2. **燃料棒控制器**， 放置在各个燃料棒的上方
3. **燃料棒**，在内部以设定图案放置
4. **流体**散热方块，若有配置则每方块消耗 1000mB 流体
5. **固体**散热方块，放置在内部剩余空间

## 常见用法

1. 在搭建反应堆的位置**放置**建造器（注意朝向）；
2. **打开**GUI，设定**尺寸**、 **燃料棒图案**、 **图案排布方式**和散热方块类型，若有需要还可设置**顶部开放**；
3. 显示**预览**，紫色为边框、黄色为燃料棒、红色为多余方块；
4. 标记内部格子过滤（参见“标记输入”按钮的说明）；
5. 原料足够时开始**建造**，需要编辑或出现红色区域时**停止***；
6. **移除或忽略**建造器方块，其不属于反应堆结构；
7. 建造完成后**手动添加**[控制器、能量接口和资源接口](getting_started.md)。

建造器的**模拟**功能能够在不建造反应堆的情况下估算反应堆属性和建造所需材料。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="/assets/assemblies/minimal_reactor_automation.snbt" />
  <IsometricCamera yaw="210" pitch="25" />
</GameScene>

**搭建完成**时的布局示例，外壳由建造器放置，控制器和接口有人工放置。参见[入门指南](getting_started.md)。
