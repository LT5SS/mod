# Minecraft 1.20.1 Forge 模组示例工程 (ExampleMod)

本项目是一个完整的 Minecraft 1.20.1 Forge 模组工程结构与基础代码模板。

## 包含功能
1. **自定义物品**：红宝石 (Ruby)
2. **自定义方块**：红宝石块 (Ruby Block)，包含方块物品注册与物理属性
3. **独立创造模式物品栏**：拥有专属的创造模式标签页 (Creative Mode Tab)
4. **合成配方**：
   - 9个红宝石合成1个红宝石块
   - 1个红宝石块无序分解为9个红宝石
5. **本地化与模型**：中英文双语支持 (`zh_cn.json`, `en_us.json`)，方块状态及物品模型定义

## 如何在本地运行与构建
1. **安装环境要求**：
   - Java 17 (JDK 17)
   - IntelliJ IDEA 或 Eclipse
2. **导入与配置**：
   - 使用 IntelliJ IDEA 打开此解压后的文件夹。
   - 确保从官方下载并配置好了 Forge 1.20.1 MDK 的 gradlew 包装器（或运行本地 gradle）。
   - 终端中运行：
     - Windows: `gradlew genIntellijRuns`
     - Linux/macOS: `./gradlew genIntellijRuns`
3. **编译构建为 .jar**：
   - 运行：`./gradlew build`
   - 构建产物将位于 `build/libs/examplemod-1.20.1-1.0.0.jar`，可直接放入 Minecraft 客户端/服务端的 `mods` 文件夹中使用！
