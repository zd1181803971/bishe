/*
 Navicat Premium Data Transfer

 Source Server         : Mysql 8.0
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 121.5.224.141:3306
 Source Schema         : renren_bishe

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 27/05/2021 12:42:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dzu_customer
-- ----------------------------
DROP TABLE IF EXISTS `dzu_customer`;
CREATE TABLE `dzu_customer`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户公司名',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司经理',
  `level` tinyint(0) DEFAULT NULL COMMENT '客户级别 1-5',
  `satisfied` tinyint(0) DEFAULT NULL COMMENT '客户满意度0-100',
  `credit` tinyint(0) DEFAULT NULL COMMENT '客户信用度0-100',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户详细地址',
  `post_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮编',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `web_site` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '官网',
  `business_license` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '营业执照',
  `legal_representative` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户法定代表人',
  `registered_capital` bigint(0) DEFAULT NULL COMMENT '注册资金',
  `turnover` bigint(0) DEFAULT NULL COMMENT '营业额',
  `bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开户行',
  `bank_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行账户',
  `state_tax` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国税账户',
  `land_tax` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地税账户',
  `state` tinyint(0) DEFAULT NULL COMMENT '客户状态 0流失 1正常',
  `is_valid` tinyint(0) DEFAULT 1 COMMENT '有效状态 0删除 1正常',
  `create_date` datetime(0) DEFAULT NULL,
  `update_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_customer
-- ----------------------------
INSERT INTO `dzu_customer` VALUES (37, 'HK001', '腾讯', '北京', '马化腾', 5, 40, 70, '北京第三区', '邮编', '18753418231', 'www.tengxun.com', '职业映照', '马化腾', 1000, 10000, '中国银行', '银行账户', '国税账户', '地税账户', 1, 1, NULL, '2021-05-03 21:37:16');
INSERT INTO `dzu_customer` VALUES (39, 'HK002', '阿里云', '上海', '马云', 4, 90, 90, '上海', '250031', '18788888888', 'www.aliyun.com', '12689654563', '马云', 10000, 1000, '中行', '25435235', '11324215', '23453245', 1, 1, '2021-05-03 21:33:35', '2021-05-03 21:37:09');
INSERT INTO `dzu_customer` VALUES (40, 'HK003', '百度', '上海', '李彦宏', 5, 80, 10, '上海', '', '', '', '', '', NULL, NULL, '', '', '', '', 1, 1, '2021-05-03 21:38:16', NULL);
INSERT INTO `dzu_customer` VALUES (46, 'HK004', '测试', '山东', '张三', 1, 100, 100, '', '', '', '', '', '', NULL, NULL, '', '', '', '', 0, 1, '2021-05-06 22:38:07', NULL);

-- ----------------------------
-- Table structure for dzu_customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `dzu_customer_loss`;
CREATE TABLE `dzu_customer_loss`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '流失客户id',
  `cus_number` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户编号',
  `cus_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户公司名',
  `cus_manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户经理',
  `last_order_time` date DEFAULT NULL COMMENT '最后下单时间',
  `confirm_loss_time` date DEFAULT NULL COMMENT '确认流失时间',
  `state` tinyint(0) DEFAULT NULL COMMENT '状态 0暂缓流失 1流失',
  `loss_reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '流失原因',
  `is_valid` tinyint(0) DEFAULT 1,
  `create_date` datetime(0) DEFAULT NULL,
  `update_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 404 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户流失表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_customer_loss
-- ----------------------------
INSERT INTO `dzu_customer_loss` VALUES (402, '测试', '123', '123', '2021-05-03', '2021-05-03', 1, 'ces', 1, '2021-05-02 16:52:32', NULL);
INSERT INTO `dzu_customer_loss` VALUES (403, 'HK004', '华为', '任正非 ', NULL, NULL, 0, NULL, 1, '2021-05-03 23:44:00', NULL);
INSERT INTO `dzu_customer_loss` VALUES (404, 'HK004', '测试', '张三', NULL, NULL, 0, NULL, 1, '2021-05-11 15:43:12', NULL);

-- ----------------------------
-- Table structure for dzu_customer_reprieve
-- ----------------------------
DROP TABLE IF EXISTS `dzu_customer_reprieve`;
CREATE TABLE `dzu_customer_reprieve`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `loss_id` int(0) DEFAULT NULL,
  `measure` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_valid` int(0) DEFAULT 1,
  `create_date` datetime(0) DEFAULT NULL,
  `update_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户流失暂缓表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dzu_department
-- ----------------------------
DROP TABLE IF EXISTS `dzu_department`;
CREATE TABLE `dzu_department`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  `parentId` bigint(0) DEFAULT NULL COMMENT '上级部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_department
-- ----------------------------
INSERT INTO `dzu_department` VALUES (1, '股东会', 1);
INSERT INTO `dzu_department` VALUES (4, '董事会', 1);
INSERT INTO `dzu_department` VALUES (5, '总办', 4);
INSERT INTO `dzu_department` VALUES (8, '财务部', 5);
INSERT INTO `dzu_department` VALUES (78, '市场部', 5);
INSERT INTO `dzu_department` VALUES (81, '华北市场部', 78);
INSERT INTO `dzu_department` VALUES (82, '华南市场部', 78);
INSERT INTO `dzu_department` VALUES (85, '石家庄市场部', 81);
INSERT INTO `dzu_department` VALUES (86, '西北市场部', 78);
INSERT INTO `dzu_department` VALUES (87, '西安市场', 86);
INSERT INTO `dzu_department` VALUES (89, '莲湖区市场', 87);
INSERT INTO `dzu_department` VALUES (91, '技术部', 5);
INSERT INTO `dzu_department` VALUES (92, '运维部', 5);
INSERT INTO `dzu_department` VALUES (95, '公司', -1);

-- ----------------------------
-- Table structure for dzu_employee
-- ----------------------------
DROP TABLE IF EXISTS `dzu_employee`;
CREATE TABLE `dzu_employee`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工姓名',
  `jobNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工工号',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `wedlock` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '婚姻状况',
  `nationId` bigint(0) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `politicId` bigint(0) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系地址',
  `departmentId` bigint(0) DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` bigint(0) DEFAULT NULL COMMENT '职称ID',
  `posId` bigint(0) DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workState` tinyint(0) DEFAULT NULL COMMENT '在职状态 1 在职 0离职',
  `notWorkDate` date DEFAULT NULL COMMENT '离职日期',
  `beginContract` date DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date DEFAULT NULL COMMENT '合同终止日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dzu_employee_pk`(`jobNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1549 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_employee
-- ----------------------------
INSERT INTO `dzu_employee` VALUES (1531, '刘二', 'admin', '男', NULL, '', '', 4, '', 2, '', '', '', 4, 12, 29, '劳动合同', '', '', '德州学院', '2021-04-13', 1, NULL, '2021-04-20', '2021-04-30');
INSERT INTO `dzu_employee` VALUES (1535, '张三', 'dzu001', '男', '2021-04-19', '371425199908264378', '已婚', 3, '山东', 4, '1181803971@qq.com', '18753418231', '山东济南', 1, 9, 30, '劳动合同', '', '计算机', '德州学院', '2021-04-13', 0, '2021-04-29', '2021-04-13', '2022-04-30');
INSERT INTO `dzu_employee` VALUES (1536, '李四', 'dzu002', '', NULL, '', '', 1, '', 3, '', '', '', 8, 13, 31, '临时雇佣', '', '', '', '2021-04-11', 0, '2021-04-28', '2021-04-11', '2023-04-27');
INSERT INTO `dzu_employee` VALUES (1542, '问题', 'dzu006', '', NULL, '', '', 4, '', 4, '', '', '', 5, 10, 29, '临时雇佣', '', '', '', '2021-04-28', 0, '2021-04-28', '2021-04-28', '2023-05-30');
INSERT INTO `dzu_employee` VALUES (1544, '测试员工', 'dzu666', '男', '2000-01-03', '371425199908264378', '已婚', 3, '山东', 4, '1181803971@qq.com', '18753418231', '山东德州', 8, 10, 29, '临时雇佣', '', '计算机专业', '德州学院', '2021-05-14', 1, NULL, '2021-05-14', '2023-04-12');
INSERT INTO `dzu_employee` VALUES (1545, '管理测试', 'dzu888', '男', '2000-01-03', '371425199908264378', '已婚', 1, '达瓦', 2, '1181803971@qq.com', '18753418231', '山东', 4, 9, 31, '临时雇佣', '', '信息', '德州学院', '2021-05-04', 1, NULL, '2021-05-04', '2023-07-06');
INSERT INTO `dzu_employee` VALUES (1549, '测试', 'dzu010', '', NULL, '', '', 2, '', 2, '', '', '', 4, 10, 31, '劳务派遣', '', '', '', '2021-05-07', 1, NULL, '2021-05-07', '2026-07-09');

-- ----------------------------
-- Table structure for dzu_employeeec
-- ----------------------------
DROP TABLE IF EXISTS `dzu_employeeec`;
CREATE TABLE `dzu_employeeec`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `eid` bigint(0) DEFAULT NULL COMMENT '员工id',
  `ecDate` date DEFAULT NULL COMMENT '报工日期',
  `ecReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作内容',
  `ecHour` bigint(0) DEFAULT NULL COMMENT '工作时长',
  `ecType` tinyint(1) DEFAULT NULL COMMENT '报工情况  0报工 1请假 2旷工',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工报工表》》修改' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_employeeec
-- ----------------------------
INSERT INTO `dzu_employeeec` VALUES (10, 1544, '2021-04-30', NULL, 0, 1, '事假');
INSERT INTO `dzu_employeeec` VALUES (11, 1544, '2021-04-30', NULL, 0, 1, '其他');
INSERT INTO `dzu_employeeec` VALUES (12, 1544, '2021-05-04', NULL, 0, 1, '病假');
INSERT INTO `dzu_employeeec` VALUES (13, 1544, '2021-05-06', '测试工作', 10, 0, '测试');
INSERT INTO `dzu_employeeec` VALUES (14, 1545, '2021-05-06', '888测试', 9, 0, '888');
INSERT INTO `dzu_employeeec` VALUES (15, 1544, '2021-05-07', NULL, 0, 1, '病假');
INSERT INTO `dzu_employeeec` VALUES (16, 1544, '2021-05-08', '问问', 0, 0, '11');
INSERT INTO `dzu_employeeec` VALUES (17, 1545, '2021-05-08', '测试', 8, 0, '测试');
INSERT INTO `dzu_employeeec` VALUES (21, 1545, '2021-05-09', '测试', 10, 0, '测试');
INSERT INTO `dzu_employeeec` VALUES (22, 1544, '2021-05-11', '213', 9, 0, '123');

-- ----------------------------
-- Table structure for dzu_joblevel
-- ----------------------------
DROP TABLE IF EXISTS `dzu_joblevel`;
CREATE TABLE `dzu_joblevel`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职称名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工职称等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_joblevel
-- ----------------------------
INSERT INTO `dzu_joblevel` VALUES (9, '教授');
INSERT INTO `dzu_joblevel` VALUES (10, '副教授');
INSERT INTO `dzu_joblevel` VALUES (12, '助教');
INSERT INTO `dzu_joblevel` VALUES (13, '讲师');
INSERT INTO `dzu_joblevel` VALUES (14, '初级工程师');
INSERT INTO `dzu_joblevel` VALUES (15, '中级工程师');
INSERT INTO `dzu_joblevel` VALUES (16, '高级工程师');
INSERT INTO `dzu_joblevel` VALUES (17, '骨灰级工程师');

-- ----------------------------
-- Table structure for dzu_leave
-- ----------------------------
DROP TABLE IF EXISTS `dzu_leave`;
CREATE TABLE `dzu_leave`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `eid` bigint(0) DEFAULT NULL COMMENT '用户id',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `reason` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '请假原因',
  `status` tinyint(1) DEFAULT NULL COMMENT '请假状态 0审批中 1通过 2不通过 3 销假',
  `message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '请假表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_leave
-- ----------------------------
INSERT INTO `dzu_leave` VALUES (27, 1531, '2021-04-28', '2021-04-30', '事假', 2, '123');
INSERT INTO `dzu_leave` VALUES (28, 1531, '2021-04-28', '2021-04-30', '事假', 3, '123');
INSERT INTO `dzu_leave` VALUES (29, 1531, '2021-04-30', '2021-04-30', '婚假', 3, '123');
INSERT INTO `dzu_leave` VALUES (32, 1544, '2021-04-30', '2021-04-30', '其他', 3, '测试请假');
INSERT INTO `dzu_leave` VALUES (34, 1544, '2021-05-07', '2021-05-08', '病假', 3, '123');
INSERT INTO `dzu_leave` VALUES (36, 1544, '2021-05-11', '2021-05-12', '事假', 0, '123');

-- ----------------------------
-- Table structure for dzu_msgcontent
-- ----------------------------
DROP TABLE IF EXISTS `dzu_msgcontent`;
CREATE TABLE `dzu_msgcontent`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '信息通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_msgcontent
-- ----------------------------
INSERT INTO `dzu_msgcontent` VALUES (18, '企业运营支撑系统成功发布', '企业运营支撑系统成功发布于2021年四月，系统可以更好的服务企业员工，公司现代化的管控工具。', '2021-03-25 14:06:39');

-- ----------------------------
-- Table structure for dzu_nation
-- ----------------------------
DROP TABLE IF EXISTS `dzu_nation`;
CREATE TABLE `dzu_nation`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工民族表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_nation
-- ----------------------------
INSERT INTO `dzu_nation` VALUES (1, '汉族');
INSERT INTO `dzu_nation` VALUES (2, '蒙古族');
INSERT INTO `dzu_nation` VALUES (3, '回族');
INSERT INTO `dzu_nation` VALUES (4, '藏族');
INSERT INTO `dzu_nation` VALUES (5, '维吾尔族');
INSERT INTO `dzu_nation` VALUES (6, '苗族');
INSERT INTO `dzu_nation` VALUES (7, '彝族');
INSERT INTO `dzu_nation` VALUES (8, '壮族');
INSERT INTO `dzu_nation` VALUES (9, '布依族');
INSERT INTO `dzu_nation` VALUES (10, '朝鲜族');
INSERT INTO `dzu_nation` VALUES (11, '满族');
INSERT INTO `dzu_nation` VALUES (12, '侗族');
INSERT INTO `dzu_nation` VALUES (13, '瑶族');
INSERT INTO `dzu_nation` VALUES (14, '白族');
INSERT INTO `dzu_nation` VALUES (15, '土家族');
INSERT INTO `dzu_nation` VALUES (16, '哈尼族');
INSERT INTO `dzu_nation` VALUES (17, '哈萨克族');
INSERT INTO `dzu_nation` VALUES (18, '傣族');
INSERT INTO `dzu_nation` VALUES (19, '黎族');
INSERT INTO `dzu_nation` VALUES (20, '傈僳族');
INSERT INTO `dzu_nation` VALUES (21, '佤族');
INSERT INTO `dzu_nation` VALUES (22, '畲族');
INSERT INTO `dzu_nation` VALUES (23, '高山族');
INSERT INTO `dzu_nation` VALUES (24, '拉祜族');
INSERT INTO `dzu_nation` VALUES (25, '水族');
INSERT INTO `dzu_nation` VALUES (26, '东乡族');
INSERT INTO `dzu_nation` VALUES (27, '纳西族');
INSERT INTO `dzu_nation` VALUES (28, '景颇族');
INSERT INTO `dzu_nation` VALUES (29, '柯尔克孜族');
INSERT INTO `dzu_nation` VALUES (30, '土族');
INSERT INTO `dzu_nation` VALUES (31, '达斡尔族');
INSERT INTO `dzu_nation` VALUES (32, '仫佬族');
INSERT INTO `dzu_nation` VALUES (33, '羌族');
INSERT INTO `dzu_nation` VALUES (34, '布朗族');
INSERT INTO `dzu_nation` VALUES (35, '撒拉族');
INSERT INTO `dzu_nation` VALUES (36, '毛难族');
INSERT INTO `dzu_nation` VALUES (37, '仡佬族');
INSERT INTO `dzu_nation` VALUES (38, '锡伯族');
INSERT INTO `dzu_nation` VALUES (39, '阿昌族');
INSERT INTO `dzu_nation` VALUES (40, '普米族');
INSERT INTO `dzu_nation` VALUES (41, '塔吉克族');
INSERT INTO `dzu_nation` VALUES (42, '怒族');
INSERT INTO `dzu_nation` VALUES (43, '乌孜别克族');
INSERT INTO `dzu_nation` VALUES (44, '俄罗斯族');
INSERT INTO `dzu_nation` VALUES (45, '鄂温克族');
INSERT INTO `dzu_nation` VALUES (46, '崩龙族');
INSERT INTO `dzu_nation` VALUES (47, '保安族');
INSERT INTO `dzu_nation` VALUES (48, '裕固族');
INSERT INTO `dzu_nation` VALUES (49, '京族');
INSERT INTO `dzu_nation` VALUES (50, '塔塔尔族');
INSERT INTO `dzu_nation` VALUES (51, '独龙族');
INSERT INTO `dzu_nation` VALUES (52, '鄂伦春族');
INSERT INTO `dzu_nation` VALUES (53, '赫哲族');
INSERT INTO `dzu_nation` VALUES (54, '门巴族');
INSERT INTO `dzu_nation` VALUES (55, '珞巴族');
INSERT INTO `dzu_nation` VALUES (56, '基诺族');

-- ----------------------------
-- Table structure for dzu_oliticsstatus
-- ----------------------------
DROP TABLE IF EXISTS `dzu_oliticsstatus`;
CREATE TABLE `dzu_oliticsstatus`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工政治面貌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_oliticsstatus
-- ----------------------------
INSERT INTO `dzu_oliticsstatus` VALUES (1, '中共党员');
INSERT INTO `dzu_oliticsstatus` VALUES (2, '中共预备党员');
INSERT INTO `dzu_oliticsstatus` VALUES (3, '共青团员');
INSERT INTO `dzu_oliticsstatus` VALUES (4, '民革党员');
INSERT INTO `dzu_oliticsstatus` VALUES (5, '民盟盟员');
INSERT INTO `dzu_oliticsstatus` VALUES (6, '民建会员');
INSERT INTO `dzu_oliticsstatus` VALUES (7, '民进会员');
INSERT INTO `dzu_oliticsstatus` VALUES (8, '农工党党员');
INSERT INTO `dzu_oliticsstatus` VALUES (9, '致公党党员');
INSERT INTO `dzu_oliticsstatus` VALUES (10, '九三学社社员');
INSERT INTO `dzu_oliticsstatus` VALUES (11, '台盟盟员');
INSERT INTO `dzu_oliticsstatus` VALUES (12, '无党派民主人士');
INSERT INTO `dzu_oliticsstatus` VALUES (13, '普通公民');

-- ----------------------------
-- Table structure for dzu_position
-- ----------------------------
DROP TABLE IF EXISTS `dzu_position`;
CREATE TABLE `dzu_position`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工职位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_position
-- ----------------------------
INSERT INTO `dzu_position` VALUES (29, '技术总监');
INSERT INTO `dzu_position` VALUES (30, '运营总监');
INSERT INTO `dzu_position` VALUES (31, '市场总监');
INSERT INTO `dzu_position` VALUES (32, '总经理');
INSERT INTO `dzu_position` VALUES (33, '研发工程师');
INSERT INTO `dzu_position` VALUES (34, '运维工程师');

-- ----------------------------
-- Table structure for dzu_salary
-- ----------------------------
DROP TABLE IF EXISTS `dzu_salary`;
CREATE TABLE `dzu_salary`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `eid` bigint(0) DEFAULT NULL,
  `basicSalary` double(11, 2) DEFAULT NULL COMMENT '基本工资',
  `bonus` double(11, 2) DEFAULT NULL COMMENT '奖金',
  `lunchSalary` double(11, 2) DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` double(11, 2) DEFAULT NULL COMMENT '交通补助',
  `allSalary` double(11, 2) DEFAULT NULL COMMENT '应发工资',
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '启用时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dzu_salary_eid_uindex`(`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工工资表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dzu_salary
-- ----------------------------
INSERT INTO `dzu_salary` VALUES (38, 1544, 3000.29, 0.33, 10.31, 201.12, 3212.05, '2021-05-08 16:40:57');
INSERT INTO `dzu_salary` VALUES (39, 1545, 4000.21, 0.00, 10.00, 2000.00, 6010.21, '2021-05-06 14:35:59');
INSERT INTO `dzu_salary` VALUES (40, 1549, 3000.53, 0.00, 10.00, 200.00, 3210.53, '2021-05-06 14:36:06');

-- ----------------------------
-- Table structure for dzu_sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `dzu_sale_chance`;
CREATE TABLE `dzu_sale_chance`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '营销机会ID',
  `chance_source` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机会来源',
  `customer_name` bigint(0) DEFAULT NULL COMMENT '客户ID',
  `probability` tinyint(0) DEFAULT NULL COMMENT '成功几率0-100',
  `overview` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '概要',
  `link_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人',
  `link_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系号码',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_man` bigint(0) DEFAULT NULL COMMENT '创建人ID',
  `assign_man` bigint(0) DEFAULT NULL COMMENT '分配人ID',
  `assign_time` datetime(0) DEFAULT NULL COMMENT '分配时间',
  `allocation_state` tinyint(0) DEFAULT NULL COMMENT '分配状态 0未分配 1已分配',
  `dev_result` tinyint(0) DEFAULT NULL COMMENT '开发状态 0未开发 1开发中 2成功 3失败',
  `is_valid` tinyint(0) DEFAULT 1 COMMENT '是否有效 0无效 1有效',
  `create_date` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销机会表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dzu_sale_chance
-- ----------------------------
INSERT INTO `dzu_sale_chance` VALUES (146, '官网', 37, 20, '测试', '百度', '18753418231', '测试', 1531, 1544, '2021-05-05 16:15:46', 1, 3, 1, '2021-05-03 16:53:06', '2021-05-06 22:27:24');
INSERT INTO `dzu_sale_chance` VALUES (147, '官网', 39, 70, '阿里巴巴', '马云', '18753418231', '阿里巴巴', 1545, 1545, '2021-05-06 23:02:25', 1, 1, 1, '2021-05-04 00:29:30', '2021-05-06 23:02:25');
INSERT INTO `dzu_sale_chance` VALUES (148, '第三方网站', 40, 80, '', '张三', '18753418231', '', 1531, 1531, '2021-05-05 16:29:25', 1, 1, 1, '2021-05-05 16:29:13', '2021-05-05 16:29:25');
INSERT INTO `dzu_sale_chance` VALUES (149, '第三方网站', 39, 20, '', '张三', '18753418231', '', 1545, 1544, '2021-05-06 22:53:54', 1, 1, 1, '2021-05-06 22:53:54', NULL);

-- ----------------------------
-- Table structure for dzu_sale_chance_plan
-- ----------------------------
DROP TABLE IF EXISTS `dzu_sale_chance_plan`;
CREATE TABLE `dzu_sale_chance_plan`  (
  `id` bigint(0) NOT NULL COMMENT '开发计划项ID',
  `sale_chance_id` bigint(0) DEFAULT NULL COMMENT '营销机会ID',
  `plan_item` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '计划项内容',
  `plan_date` datetime(0) DEFAULT NULL COMMENT '计划时间',
  `exe_affect` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行效果',
  `create_date` datetime(0) DEFAULT NULL,
  `update_date` datetime(0) DEFAULT NULL,
  `is_valid` tinyint(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '营销管理计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('03cc4ab4-9777-4a08-8bfc-dac19738a610', 'w4fwm', '2021-03-25 21:59:01');
INSERT INTO `sys_captcha` VALUES ('057a5fb3-e917-467d-852a-938fb0a53e75', 'paw7e', '2021-03-25 20:51:22');
INSERT INTO `sys_captcha` VALUES ('06673c3f-e74d-4c49-8541-9a5db3490606', 'wdbam', '2021-04-07 20:55:58');
INSERT INTO `sys_captcha` VALUES ('077eff86-ca9e-4342-8a51-23aa42dd723d', '33n44', '2021-04-10 17:01:46');
INSERT INTO `sys_captcha` VALUES ('0a32dd1b-122e-4b73-87fa-d142fbb1b918', 'e2wmn', '2021-04-17 13:26:44');
INSERT INTO `sys_captcha` VALUES ('0a8be574-19fa-4862-864e-0ac1beb2edfb', 'bd2mb', '2021-04-07 21:06:29');
INSERT INTO `sys_captcha` VALUES ('142f7081-13f3-4822-81b3-26c1cb127471', '54gxa', '2021-03-12 13:49:39');
INSERT INTO `sys_captcha` VALUES ('16157f20-e814-4fde-8635-2a9065a423c5', 'xede8', '2021-05-26 23:32:27');
INSERT INTO `sys_captcha` VALUES ('16d174d4-681d-477d-8d33-fc668e528bc9', '4n353', '2021-04-21 22:28:35');
INSERT INTO `sys_captcha` VALUES ('18880d12-0f14-4e68-8393-56d55dda5de4', '8np7e', '2021-04-10 22:17:45');
INSERT INTO `sys_captcha` VALUES ('1baea667-b4dd-4f84-82a8-fdb9b904f768', '84ccy', '2021-04-07 21:02:24');
INSERT INTO `sys_captcha` VALUES ('1de1bd33-a908-4349-8999-ed3935ae4bce', 'byfxn', '2021-03-29 18:30:39');
INSERT INTO `sys_captcha` VALUES ('1fdd322c-f29d-4dc2-898c-bc436ba5008e', 'w5gxe', '2021-04-07 21:03:46');
INSERT INTO `sys_captcha` VALUES ('22beae95-cd7b-454c-888f-869dd95988f7', 'c6ceg', '2021-04-07 21:05:08');
INSERT INTO `sys_captcha` VALUES ('23d57d9b-a85b-4c00-881f-94df43f77fed', '4dcb4', '2021-04-29 12:49:10');
INSERT INTO `sys_captcha` VALUES ('2f445378-b95f-42db-802b-c9a17744eba2', 'xym5d', '2021-03-25 21:59:01');
INSERT INTO `sys_captcha` VALUES ('3043c8ed-45fc-4b8f-8b45-68f5a3dcf07c', 'gca53', '2021-04-07 21:09:37');
INSERT INTO `sys_captcha` VALUES ('32a72c25-eb92-40dc-830e-0d7b42c2c7c0', 'e4w6b', '2021-03-31 17:38:37');
INSERT INTO `sys_captcha` VALUES ('335d973b-c63c-42cd-8517-a42a8506c247', 'ax6mg', '2021-05-09 11:49:55');
INSERT INTO `sys_captcha` VALUES ('3399d46c-91ad-420b-8742-c8fd80211a00', '2b8yy', '2021-03-12 13:48:54');
INSERT INTO `sys_captcha` VALUES ('36006eee-82a5-4412-8fd1-8ac43e74ea44', 'g7nde', '2021-04-21 00:09:54');
INSERT INTO `sys_captcha` VALUES ('363ca668-9240-4834-8a17-dd0aa31a4d0c', 'xnaae', '2021-04-02 22:48:12');
INSERT INTO `sys_captcha` VALUES ('3724a8e7-c8ed-4125-876b-5c617184a420', 'cffa4', '2021-03-31 18:38:37');
INSERT INTO `sys_captcha` VALUES ('3ad07f72-f44e-4650-8100-82c61eb1f771', '2xpxf', '2021-03-30 18:30:33');
INSERT INTO `sys_captcha` VALUES ('40ec3166-e53f-4915-8ecc-0624ecf2a636', 'x66dd', '2021-05-07 02:29:21');
INSERT INTO `sys_captcha` VALUES ('41272904-0b49-49e5-80dd-9fe66a75aee3', '8a467', '2021-03-23 17:47:06');
INSERT INTO `sys_captcha` VALUES ('41a71102-d043-460f-88d6-51eec2a8bd91', '525cb', '2021-05-08 22:39:35');
INSERT INTO `sys_captcha` VALUES ('44108613-4484-42fa-8895-c218856704a7', '7636x', '2021-04-07 20:59:40');
INSERT INTO `sys_captcha` VALUES ('4bb61fa8-8b1c-460b-8466-b2fc0f96f70e', 'm6bwp', '2021-05-14 20:35:45');
INSERT INTO `sys_captcha` VALUES ('5053e7a0-9c9d-4433-8225-737f51245cd4', '5xaa4', '2021-04-06 16:48:04');
INSERT INTO `sys_captcha` VALUES ('511d8c1c-bca3-49cc-8cf8-c0bf79543aa9', 'ebnpm', '2021-03-25 11:43:19');
INSERT INTO `sys_captcha` VALUES ('5a351cf8-f240-4d9f-81a0-5f5ac788bcd1', '4bnfp', '2021-03-25 20:51:21');
INSERT INTO `sys_captcha` VALUES ('5a4df4a7-8cc1-4d85-85c3-c92b575329de', 'apnfm', '2021-04-22 15:16:40');
INSERT INTO `sys_captcha` VALUES ('5abbd115-dc93-4b1c-8aef-cbd711d5b020', 'nd2ga', '2021-03-31 17:40:44');
INSERT INTO `sys_captcha` VALUES ('5cd4b8e6-b718-4d5c-83b3-9141e6746f99', '3gyn4', '2021-04-07 20:58:18');
INSERT INTO `sys_captcha` VALUES ('5cddfeb3-af18-4da2-8f96-47c3521cb8b1', 'anwmf', '2021-03-21 16:50:17');
INSERT INTO `sys_captcha` VALUES ('5d2d5652-a2c4-40f4-8278-d2070ba2538a', '4y65x', '2021-04-07 20:58:13');
INSERT INTO `sys_captcha` VALUES ('5e42086f-7f61-4b14-8e22-69e163b97a56', '5p7f6', '2021-04-07 21:08:14');
INSERT INTO `sys_captcha` VALUES ('63aaa553-e864-40ee-8047-d0e6b0daef7e', '4452g', '2021-04-02 22:53:13');
INSERT INTO `sys_captcha` VALUES ('64c78d28-2b40-4f5c-80de-68b86d05aa34', '87fn7', '2021-04-07 21:02:53');
INSERT INTO `sys_captcha` VALUES ('6553e502-6c9e-435c-8ed2-df889e46a9ec', 'ppebg', '2021-03-25 23:31:20');
INSERT INTO `sys_captcha` VALUES ('675bc77e-767a-45f3-8a58-7fe5b72d055b', '87cw6', '2021-04-17 13:28:23');
INSERT INTO `sys_captcha` VALUES ('69961294-2a88-4d1c-8c18-e69626b6341d', '44cpc', '2021-03-12 13:32:47');
INSERT INTO `sys_captcha` VALUES ('6bfec814-039a-474c-886d-54b3a5d33e82', '2fc88', '2021-05-08 22:43:57');
INSERT INTO `sys_captcha` VALUES ('6c64bdc5-168d-4ad5-8802-f8adeaa1122b', 'ebeff', '2021-05-08 22:46:01');
INSERT INTO `sys_captcha` VALUES ('6d792f72-e756-4ad0-890b-6d6c167e12f9', '3y322', '2021-03-28 20:33:57');
INSERT INTO `sys_captcha` VALUES ('6e94724a-5b33-4c42-8daa-7ed412331c37', 'ge4xc', '2021-04-07 21:05:25');
INSERT INTO `sys_captcha` VALUES ('6f4bc7d2-dd9a-4f7c-8b60-58959f7630e1', 'db43d', '2021-04-07 20:57:11');
INSERT INTO `sys_captcha` VALUES ('6ffb6bf1-2511-4e79-8f67-85ace0fc3bc8', 'w58f5', '2021-04-11 13:53:19');
INSERT INTO `sys_captcha` VALUES ('73a02ab4-f4cd-4e57-8d8d-2cfe27312339', 'd5g55', '2021-04-10 17:03:19');
INSERT INTO `sys_captcha` VALUES ('75d65130-727f-4b0f-84cb-3fc5e0e1297a', 'g2cam', '2021-04-17 13:27:15');
INSERT INTO `sys_captcha` VALUES ('780a5ee6-dae2-45cc-8a59-e4abcffacfb1', 'ncdpn', '2021-04-07 21:04:32');
INSERT INTO `sys_captcha` VALUES ('791f2737-0a09-40c2-80f5-0608a54b00e1', '5mewx', '2021-04-07 21:09:51');
INSERT INTO `sys_captcha` VALUES ('796abf2a-0278-4c94-827d-c71e1cda6a44', 'bw5cx', '2021-05-14 20:34:55');
INSERT INTO `sys_captcha` VALUES ('79f0b744-1fae-4cdf-87d1-c3f7c67223d8', 'gn3n7', '2021-03-25 23:32:16');
INSERT INTO `sys_captcha` VALUES ('7b0d321a-e7c8-4c54-89a6-c21b60d5142d', 'abcm8', '2021-04-07 21:01:57');
INSERT INTO `sys_captcha` VALUES ('7c172d44-7e08-4e5a-88b3-2d6bb02857cd', 'nwydd', '2021-05-11 15:04:56');
INSERT INTO `sys_captcha` VALUES ('7c814614-4480-40cd-8b2a-8d660326dd3f', '2pc6w', '2021-03-29 18:30:39');
INSERT INTO `sys_captcha` VALUES ('7ee32f10-a21e-4186-86b0-c5475b994fc9', 'b7bm7', '2021-04-10 17:01:40');
INSERT INTO `sys_captcha` VALUES ('7efa20b0-3264-4216-858b-8e4c79a030aa', 'nbedn', '2021-03-31 17:40:49');
INSERT INTO `sys_captcha` VALUES ('7f757bb2-0c44-4c16-8188-a95afceddac1', 'cwney', '2021-04-07 20:56:02');
INSERT INTO `sys_captcha` VALUES ('80624da5-750f-4b12-8893-de9fc1dc1a48', 'n6nyn', '2021-03-25 21:59:02');
INSERT INTO `sys_captcha` VALUES ('81aaef04-510a-4343-8c87-992873b9c890', 'c2858', '2021-03-28 20:33:43');
INSERT INTO `sys_captcha` VALUES ('8333bce1-afb4-4445-8e28-5f426e03503d', 'dyfpe', '2021-05-08 12:20:06');
INSERT INTO `sys_captcha` VALUES ('8544b86f-2356-4385-8f0c-dc3df79fec06', 'b3ggf', '2021-04-07 05:11:11');
INSERT INTO `sys_captcha` VALUES ('9175eec8-94df-4cea-8e35-124a3c6a8e1c', '6nb22', '2021-03-23 18:56:32');
INSERT INTO `sys_captcha` VALUES ('942ed263-3c95-470b-8c10-800ca600abe6', 'a4p2f', '2021-04-07 21:06:50');
INSERT INTO `sys_captcha` VALUES ('94721ffb-cdba-4a85-8030-0af2ac94ba0e', 'g5df3', '2021-03-12 11:51:11');
INSERT INTO `sys_captcha` VALUES ('965b2321-a62b-41ed-8291-689f0a76177d', '86fn8', '2021-04-07 21:02:45');
INSERT INTO `sys_captcha` VALUES ('98d32d4e-ba7b-4485-85ca-256dbb04fb9e', '85cad', '2021-05-14 20:35:22');
INSERT INTO `sys_captcha` VALUES ('98f19875-755a-453f-8933-2f4099566aed', 'nedgd', '2021-04-12 22:34:00');
INSERT INTO `sys_captcha` VALUES ('99f1cc3f-00fd-4291-8aef-e258b6e5c261', 'an8g8', '2021-03-30 18:30:49');
INSERT INTO `sys_captcha` VALUES ('9c45b7be-3797-4e38-856a-68fd6d3f7cad', 'd7xn2', '2021-04-18 21:25:01');
INSERT INTO `sys_captcha` VALUES ('9f37dda2-c13b-425c-8fe0-995c0d2d6a2a', 'e8dm7', '2021-03-12 13:32:14');
INSERT INTO `sys_captcha` VALUES ('a0c23e90-5314-476f-84df-07d906e75025', '48dae', '2021-03-25 20:51:15');
INSERT INTO `sys_captcha` VALUES ('a265ff1e-ab44-46df-81de-ca0b76b8de27', '28dnn', '2021-03-23 09:33:50');
INSERT INTO `sys_captcha` VALUES ('a2670db3-e227-41df-83de-fe2b49d7ac6b', '4wd48', '2021-04-07 21:06:52');
INSERT INTO `sys_captcha` VALUES ('a2735008-d52e-4bc3-892d-c0fbf8828ff8', 'fen77', '2021-04-12 22:32:36');
INSERT INTO `sys_captcha` VALUES ('a3721f1b-c5d6-43f3-85df-2aa22c45b1ea', '7x754', '2021-04-12 22:32:34');
INSERT INTO `sys_captcha` VALUES ('a4f57abf-d10c-4927-806b-eb8f3eba58f6', 'gg4c8', '2021-03-22 19:04:09');
INSERT INTO `sys_captcha` VALUES ('a88f0207-8602-4065-838e-c404eb29acf7', 'p7g3n', '2021-04-18 21:25:05');
INSERT INTO `sys_captcha` VALUES ('a89629d6-4604-4be5-8a4f-6773afce3efb', 'n6y56', '2021-04-12 22:33:31');
INSERT INTO `sys_captcha` VALUES ('aa05533f-5f77-44d6-83f7-3a7738377d17', '7dgnf', '2021-03-24 10:52:17');
INSERT INTO `sys_captcha` VALUES ('aa6c0471-5420-413a-8801-1c79cad14fc8', 'ca3nn', '2021-04-09 13:56:24');
INSERT INTO `sys_captcha` VALUES ('abd8327d-1914-4ec3-8d16-18da7960dcf0', '8xe5w', '2021-03-12 13:01:59');
INSERT INTO `sys_captcha` VALUES ('ae38e97b-50a6-4a25-8214-d5f0f850e3e1', 'pb8x8', '2021-05-27 00:58:24');
INSERT INTO `sys_captcha` VALUES ('af132c51-41b7-4249-872b-115f5112a179', 'epxd7', '2021-03-12 13:49:55');
INSERT INTO `sys_captcha` VALUES ('b1400d32-3f4a-45d0-8ba7-243529eb2d5c', 'en282', '2021-03-31 17:40:44');
INSERT INTO `sys_captcha` VALUES ('b14264d0-aa21-409e-8ec1-3894e88df65e', 'wc4b5', '2021-04-29 12:50:31');
INSERT INTO `sys_captcha` VALUES ('b5c3e8a6-27e2-4d6a-800e-0f1f7ed2b396', '8xyex', '2021-03-31 17:37:01');
INSERT INTO `sys_captcha` VALUES ('b5db83b1-a675-4e9b-8870-63d2f8f86d8c', '4mbbf', '2021-05-08 22:39:46');
INSERT INTO `sys_captcha` VALUES ('b60cc1f0-2470-4fc3-8f7c-1dbcf8d4b862', '3wcnx', '2021-03-29 18:30:38');
INSERT INTO `sys_captcha` VALUES ('b6a88749-2d99-4b8f-881f-fa73e89a4aab', 'w7awe', '2021-04-11 15:33:34');
INSERT INTO `sys_captcha` VALUES ('b87e1553-a035-4c15-8199-39f70f2cb6d5', 'x353y', '2021-04-18 21:25:02');
INSERT INTO `sys_captcha` VALUES ('b89b367e-7d56-48a6-86db-6668dab09e38', '247c3', '2021-03-20 17:13:36');
INSERT INTO `sys_captcha` VALUES ('bad2f1a1-3005-460c-8450-da1465c487d5', '2247d', '2021-05-26 17:22:57');
INSERT INTO `sys_captcha` VALUES ('bbbbc702-1547-4a0e-8304-840c7fe9d0f1', 'bnyn7', '2021-04-21 14:23:29');
INSERT INTO `sys_captcha` VALUES ('bceb124d-d0dc-480d-86d3-41ef803804e0', 'fny2b', '2021-05-26 17:19:26');
INSERT INTO `sys_captcha` VALUES ('c3d6db8e-2a68-48cd-898c-b28123b9653c', 'n572f', '2021-04-07 21:05:37');
INSERT INTO `sys_captcha` VALUES ('c566a40b-c4c1-4420-8337-9d6f7bcd86eb', '2ye7y', '2021-04-07 21:05:59');
INSERT INTO `sys_captcha` VALUES ('c6572c72-a9f0-4433-843d-33583f972a1f', 'fexca', '2021-05-06 23:17:53');
INSERT INTO `sys_captcha` VALUES ('c6e64100-8caa-4db8-8abb-b9cb3444e481', 'b2gb7', '2021-04-10 17:03:18');
INSERT INTO `sys_captcha` VALUES ('c737c929-46bb-4e4d-849b-8db149a1fc24', '3cpda', '2021-04-17 13:26:26');
INSERT INTO `sys_captcha` VALUES ('c7747c36-8f20-40e7-8c75-3b8bd64a5869', '5a6gc', '2021-05-26 17:22:13');
INSERT INTO `sys_captcha` VALUES ('c968d5a4-4679-4ef7-827a-e684ff36983f', '8m77w', '2021-03-12 13:35:32');
INSERT INTO `sys_captcha` VALUES ('c9f1c7ee-a7a8-46d1-802d-c46904ca35ab', 'c4a4a', '2021-03-25 21:59:06');
INSERT INTO `sys_captcha` VALUES ('cbe6f523-29f3-4550-8cd5-e887179c7bd6', 'cb4xm', '2021-03-23 09:31:50');
INSERT INTO `sys_captcha` VALUES ('cc078ecb-2de5-4641-86ec-ba8702e7df7f', 'efefa', '2021-03-24 12:46:01');
INSERT INTO `sys_captcha` VALUES ('cc15568d-7451-4704-8cdb-885400d085bc', 'fdnpd', '2021-04-18 20:31:45');
INSERT INTO `sys_captcha` VALUES ('ccd921a7-4c4b-4216-8139-803bc44e039f', 'bn75n', '2021-04-07 20:53:50');
INSERT INTO `sys_captcha` VALUES ('cd00987d-2634-4548-8ee3-2d19a6b885bc', 'n5836', '2021-05-05 23:24:39');
INSERT INTO `sys_captcha` VALUES ('cdc1f0b8-1b4e-424c-80af-f0e94b094548', 'yapeg', '2021-04-17 13:28:42');
INSERT INTO `sys_captcha` VALUES ('d18d2cce-7d4f-4935-8442-7ce764c4936c', 'w7b7n', '2021-04-21 12:31:03');
INSERT INTO `sys_captcha` VALUES ('d2d34a5e-70db-4af3-8528-3da07978b34e', 'f2yem', '2021-04-02 22:41:00');
INSERT INTO `sys_captcha` VALUES ('d5946184-2e1a-4bd8-8303-84cde6537645', 'gn37n', '2021-04-06 16:18:50');
INSERT INTO `sys_captcha` VALUES ('d64e9f7a-468a-4012-8c2c-f16445f778df', 'nn85f', '2021-04-07 20:55:47');
INSERT INTO `sys_captcha` VALUES ('d65a4463-6f4b-40f0-8e59-ddb74b1d8dfd', 'x7mp4', '2021-04-10 17:01:43');
INSERT INTO `sys_captcha` VALUES ('d89c57cb-7375-4726-8c3a-d0608eee8ce3', '6fngn', '2021-05-26 23:27:00');
INSERT INTO `sys_captcha` VALUES ('d9c5c145-d8ab-4544-8ab8-1189119d3552', 'pyb42', '2021-04-21 22:28:47');
INSERT INTO `sys_captcha` VALUES ('dba979da-269f-4f77-8f87-202fb9584622', 'gxp4e', '2021-04-07 21:06:25');
INSERT INTO `sys_captcha` VALUES ('dddc39f0-a000-4567-8adf-2395ec69ebdb', 'g7657', '2021-04-21 03:13:19');
INSERT INTO `sys_captcha` VALUES ('deea20e0-d9f9-4165-868a-17dd7e0c0a47', '8a62f', '2021-04-02 22:41:27');
INSERT INTO `sys_captcha` VALUES ('e000b398-024e-430e-8a41-0d7600fe4884', 'yybmp', '2021-04-07 21:03:45');
INSERT INTO `sys_captcha` VALUES ('e076c7f8-05c7-4623-8fae-0a54bcf6177e', 'nnw54', '2021-04-07 20:55:45');
INSERT INTO `sys_captcha` VALUES ('e2e1fc3e-f73a-4f4b-82d3-33671dffbda1', 'y2ycn', '2021-05-08 22:42:43');
INSERT INTO `sys_captcha` VALUES ('e4538334-5dda-42d8-88e6-13f52f4111cc', 'nym3n', '2021-05-26 16:53:24');
INSERT INTO `sys_captcha` VALUES ('e552ee36-407c-4804-81d5-548471c073ad', '7xc83', '2021-03-20 18:02:13');
INSERT INTO `sys_captcha` VALUES ('e937603a-fb6a-4240-8723-7d15aca3c13a', 'n5bg6', '2021-04-07 21:01:39');
INSERT INTO `sys_captcha` VALUES ('e93d30c4-cf3e-4537-8221-85b48a2b3820', '7m5p5', '2021-03-12 12:59:56');
INSERT INTO `sys_captcha` VALUES ('eb21a13c-c08f-4aa5-860a-9044560e951c', 'nnya7', '2021-04-07 21:00:31');
INSERT INTO `sys_captcha` VALUES ('eb2c3f46-4249-4746-86ab-c0d34f4b8ebb', 'g75gd', '2021-03-23 09:31:15');
INSERT INTO `sys_captcha` VALUES ('f4d55808-5f6a-466f-8334-ff250b2dcf50', '2b774', '2021-04-29 13:54:59');
INSERT INTO `sys_captcha` VALUES ('f500509e-b0ca-4696-85e6-5f7a03415c91', 'gxwa8', '2021-04-07 20:55:34');
INSERT INTO `sys_captcha` VALUES ('f5df7904-71ed-4cec-8190-d8fd5eb794c7', 'n8mfn', '2021-03-20 17:17:50');
INSERT INTO `sys_captcha` VALUES ('f7ee044f-be81-487a-808d-5cf4bf01f84a', 'n7mpx', '2021-04-11 15:33:36');
INSERT INTO `sys_captcha` VALUES ('fac79825-c1d9-4a26-8e64-cc60daaea71f', 'nna76', '2021-05-08 23:07:24');
INSERT INTO `sys_captcha` VALUES ('fd95530e-18b7-4d2f-80e2-963dd44f7572', '4mdnd', '2021-03-24 09:49:01');
INSERT INTO `sys_captcha` VALUES ('feef658a-c4bb-414e-8c78-aad8549f22e8', '3g75d', '2021-05-26 23:23:26');
INSERT INTO `sys_captcha` VALUES ('ff8d4499-de38-4df1-877e-7253b138faac', 'ygx7c', '2021-03-22 08:44:25');
INSERT INTO `sys_captcha` VALUES ('ffd39c66-878c-4819-8249-c12793d5630d', '8cwax', '2021-03-25 20:50:14');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(0) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单URL',
  `type` int(0) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(0) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, 0, 'system', 10);
INSERT INTO `sys_menu` VALUES (2, 1, '系统账号管理', 'sys/user', 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '系统角色管理', 'sys/role', 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://localhost:8080/dzu/druid/sql.html', 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (40, 99, '部门管理', 'dzu/department', 1, 'zonghe', 6);
INSERT INTO `sys_menu` VALUES (45, 95, '员工个人资料', 'dzu/employee', 1, 'zhedie', 2);
INSERT INTO `sys_menu` VALUES (50, 95, '报工管理', 'dzu/employeeec', 1, 'config', 5);
INSERT INTO `sys_menu` VALUES (65, 99, '职称管理', 'dzu/joblevel', 1, 'zonghe', 5);
INSERT INTO `sys_menu` VALUES (70, 99, '首页通知管理', 'dzu/msgcontent', 1, 'tixing', 1);
INSERT INTO `sys_menu` VALUES (75, 99, '民族管理', 'dzu/nation', 1, 'zonghe', 6);
INSERT INTO `sys_menu` VALUES (80, 99, '政治面貌管理', 'dzu/oliticsstatus', 1, 'zonghe', 6);
INSERT INTO `sys_menu` VALUES (85, 99, '职位管理', 'dzu/position', 1, 'zonghe', 6);
INSERT INTO `sys_menu` VALUES (90, 95, '个人薪资', 'dzu/salary', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (95, 0, '员工管理', '', 0, 'admin', 0);
INSERT INTO `sys_menu` VALUES (98, 0, '统计管理', '', 0, 'tubiao', 4);
INSERT INTO `sys_menu` VALUES (99, 0, '基础信息管理', '', 0, 'shezhi', 5);
INSERT INTO `sys_menu` VALUES (100, 95, '员工资料管理', '/admin/employeeAdmin', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (101, 95, '个人请假', 'dzu/leave', 1, 'zhedie', 4);
INSERT INTO `sys_menu` VALUES (106, 95, '请假管理', 'admin/leaveAdmin', 1, 'zhedie', 3);
INSERT INTO `sys_menu` VALUES (107, 95, '员工薪资管理', '/admin/salaryAdmin', 1, 'zhedie', 6);
INSERT INTO `sys_menu` VALUES (108, 98, '员工人数统计', '/dzu/empUserCount', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (109, 98, '员工工资统计', '/dzu/empSalayCount', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (111, 0, '客户管理', '', 0, 'admin', 0);
INSERT INTO `sys_menu` VALUES (112, 0, '营销管理', '', 0, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (113, 111, '客户信息管理', '/customer/customer', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (114, 111, '客户流失管理', '/customer/customerloss', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (115, 112, '营销机会管理', '/customer/salechance', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (116, 112, '客户开发计划', '/customer/customerdev', 1, 'zhedie', 2);
INSERT INTO `sys_menu` VALUES (117, 98, '客户构成统计', '/customer/customercount', 1, 'zhedie', 3);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(0) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (2, '员工', '员工', NULL, '2021-05-02 14:30:28');
INSERT INTO `sys_role` VALUES (4, '管理员', '管理员', NULL, '2021-05-06 11:54:04');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(0) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 251 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (106, 2, 45);
INSERT INTO `sys_role_menu` VALUES (107, 2, 90);
INSERT INTO `sys_role_menu` VALUES (108, 2, 101);
INSERT INTO `sys_role_menu` VALUES (109, 2, 98);
INSERT INTO `sys_role_menu` VALUES (110, 2, 108);
INSERT INTO `sys_role_menu` VALUES (111, 2, 109);
INSERT INTO `sys_role_menu` VALUES (112, 2, 117);
INSERT INTO `sys_role_menu` VALUES (113, 2, 116);
INSERT INTO `sys_role_menu` VALUES (114, 2, -666666);
INSERT INTO `sys_role_menu` VALUES (115, 2, 95);
INSERT INTO `sys_role_menu` VALUES (116, 2, 112);
INSERT INTO `sys_role_menu` VALUES (228, 4, 5);
INSERT INTO `sys_role_menu` VALUES (229, 4, 50);
INSERT INTO `sys_role_menu` VALUES (230, 4, 100);
INSERT INTO `sys_role_menu` VALUES (231, 4, 106);
INSERT INTO `sys_role_menu` VALUES (232, 4, 107);
INSERT INTO `sys_role_menu` VALUES (233, 4, 98);
INSERT INTO `sys_role_menu` VALUES (234, 4, 108);
INSERT INTO `sys_role_menu` VALUES (235, 4, 109);
INSERT INTO `sys_role_menu` VALUES (236, 4, 117);
INSERT INTO `sys_role_menu` VALUES (237, 4, 99);
INSERT INTO `sys_role_menu` VALUES (238, 4, 40);
INSERT INTO `sys_role_menu` VALUES (239, 4, 65);
INSERT INTO `sys_role_menu` VALUES (240, 4, 70);
INSERT INTO `sys_role_menu` VALUES (241, 4, 75);
INSERT INTO `sys_role_menu` VALUES (242, 4, 80);
INSERT INTO `sys_role_menu` VALUES (243, 4, 85);
INSERT INTO `sys_role_menu` VALUES (244, 4, 111);
INSERT INTO `sys_role_menu` VALUES (245, 4, 113);
INSERT INTO `sys_role_menu` VALUES (246, 4, 114);
INSERT INTO `sys_role_menu` VALUES (247, 4, 115);
INSERT INTO `sys_role_menu` VALUES (248, 4, -666666);
INSERT INTO `sys_role_menu` VALUES (249, 4, 1);
INSERT INTO `sys_role_menu` VALUES (250, 4, 95);
INSERT INTO `sys_role_menu` VALUES (251, 4, 112);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `status` tinyint(0) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(0) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`, `username`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '1181803971@qq.com', '18753418231', 1, 1, '2021-04-11 14:02:10');
INSERT INTO `sys_user` VALUES (28, 'dzu666', '330ae231370cfbeefcf2e2e49ad587948db211b83a3ad72364b82f37ecfa10da', 'qInVyGlfEMJODquSvlK1', '1181803971@qq.com', '18753418231', 1, NULL, '2021-04-29 12:39:28');
INSERT INTO `sys_user` VALUES (29, 'dzu888', 'fc6b9afdf44ee905eac204415c504a9b3144cd7f0a3449bb3f16926e1048a9ee', 'pQTX9FTocs85zPIWNTry', '1181803971@qq.com', '18753418231', 1, NULL, '2021-05-03 23:23:23');
INSERT INTO `sys_user` VALUES (30, 'dzu010', '0a7678f9e1b5b6bd58f8b56c29f2dc97f6352703509d5f5b2459a6239b593a41', '6y1wr5fDy5KabKabU16q', NULL, NULL, 1, NULL, '2021-05-06 22:31:49');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(0) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (21, 28, 2);
INSERT INTO `sys_user_role` VALUES (26, 30, 2);
INSERT INTO `sys_user_role` VALUES (27, 29, 4);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(0) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, 'b0e157865c47750ee2232e16bbbf8972', '2021-05-27 05:09:10', '2021-05-26 17:09:10');
INSERT INTO `sys_user_token` VALUES (2, '47921e9682c57ef92dbcab27d55801fb', '2021-03-25 04:38:48', '2021-03-24 16:38:48');
INSERT INTO `sys_user_token` VALUES (8, '197a1d205cff88bbfaa7e35346717b06', '2021-03-25 05:45:27', '2021-03-24 17:45:27');
INSERT INTO `sys_user_token` VALUES (10, '97776de32cffc2153989e56ce0bb1bdb', '2021-03-25 05:45:48', '2021-03-24 17:45:48');
INSERT INTO `sys_user_token` VALUES (14, '6a49f5560d1df4f4edf6c2e2aaea0ba3', '2021-03-25 05:55:07', '2021-03-24 17:55:07');
INSERT INTO `sys_user_token` VALUES (15, '648988e63e836c6a318b96d195c9426b', '2021-04-08 09:30:28', '2021-04-07 21:30:28');
INSERT INTO `sys_user_token` VALUES (21, 'ed7aaaff85a9710776fd595c0311a490', '2021-04-22 11:00:13', '2021-04-21 23:00:13');
INSERT INTO `sys_user_token` VALUES (28, '16a2e228f02941b7b33359b45c4bc0cd', '2021-05-12 03:17:54', '2021-05-11 15:17:54');
INSERT INTO `sys_user_token` VALUES (29, 'a74eb13e3fe966f5f49957e925283956', '2021-05-12 03:00:09', '2021-05-11 15:00:09');

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
    declare did int;
    declare pDepPath varchar(64);
    insert into department set name=depName,parentId=parentId,enabled=enabled;
    select row_count() into result;
    select last_insert_id() into did;
    set result2=did;
    select depPath into pDepPath from department where id=parentId;
    update department set depPath=concat(pDepPath,'.',did) where id=did;
    update department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
    declare ecount int;
    declare pid int;
    declare pcount int;
    select count(*) into ecount from employee where departmentId=did;
    if ecount>0 then set result=-1;
    else
        select parentId into pid from department where id=did;
        delete from department where id=did and isParent=false;
        select row_count() into result;
        select count(*) into pcount from department where parentId=pid;
        if pcount=0 then update department set isParent=false where id=pid;
        end if;
    end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
