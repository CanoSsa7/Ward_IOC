/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 24/05/2024 23:24:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for medical_orders
-- ----------------------------
DROP TABLE IF EXISTS `medical_orders`;
CREATE TABLE `medical_orders`  (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '医嘱ID',
  `order_detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医嘱详情',
  `execution_nurse_id` int NULL DEFAULT NULL COMMENT '执行护士ID',
  `timestamp` datetime NULL DEFAULT NULL COMMENT '医嘱时间戳',
  `last_execution_time` datetime NULL DEFAULT NULL COMMENT '上一次执行时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medical_orders
-- ----------------------------
INSERT INTO `medical_orders` VALUES (1, '每日早晚各测量血压一次', 1, '2024-05-01 08:00:00', '2024-05-01 20:00:00');
INSERT INTO `medical_orders` VALUES (2, '术后每日换药一次', 2, '2024-05-02 09:00:00', '2024-05-02 09:00:00');
INSERT INTO `medical_orders` VALUES (3, '注射抗生素，每日三次', 3, '2024-05-03 10:00:00', '2024-05-03 18:00:00');
INSERT INTO `medical_orders` VALUES (4, '定时吸氧，每日两次', 4, '2024-05-04 11:00:00', '2024-05-04 16:00:00');

-- ----------------------------
-- Table structure for nurses
-- ----------------------------
DROP TABLE IF EXISTS `nurses`;
CREATE TABLE `nurses`  (
  `nurse_id` int NOT NULL AUTO_INCREMENT COMMENT '护士ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '科室',
  PRIMARY KEY (`nurse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurses
-- ----------------------------
INSERT INTO `nurses` VALUES (1, '李华', '女', 30, '内科');
INSERT INTO `nurses` VALUES (2, '张伟', '男', 35, '外科');
INSERT INTO `nurses` VALUES (3, '王芳', '女', 28, '儿科');
INSERT INTO `nurses` VALUES (4, '赵强', '男', 32, '急诊科');

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint NULL DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for patient_medical_orders
-- ----------------------------
DROP TABLE IF EXISTS `patient_medical_orders`;
CREATE TABLE `patient_medical_orders`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '关系表ID',
  `patient_id` int NULL DEFAULT NULL COMMENT '病人ID',
  `order_id` int NULL DEFAULT NULL COMMENT '医嘱ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient_medical_orders
-- ----------------------------
INSERT INTO `patient_medical_orders` VALUES (1, 1, 1);
INSERT INTO `patient_medical_orders` VALUES (2, 2, 2);
INSERT INTO `patient_medical_orders` VALUES (3, 3, 3);
INSERT INTO `patient_medical_orders` VALUES (4, 4, 4);
INSERT INTO `patient_medical_orders` VALUES (5, 1, 3);
INSERT INTO `patient_medical_orders` VALUES (6, 2, 4);

-- ----------------------------
-- Table structure for patients
-- ----------------------------
DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients`  (
  `patient_id` int NOT NULL AUTO_INCREMENT COMMENT '病人ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `admission_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '住院号',
  `admission_date` date NULL DEFAULT NULL COMMENT '住院日期',
  `attending_doctor` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主治医生',
  `responsible_nurse_id` int NULL DEFAULT NULL COMMENT '责任护士ID',
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patients
-- ----------------------------
INSERT INTO `patients` VALUES (1, '刘强', '男', 45, 'A123456', '2024-05-01', '李医生', 1);
INSERT INTO `patients` VALUES (2, '李敏', '女', 34, 'B654321', '2024-05-02', '张医生', 2);
INSERT INTO `patients` VALUES (3, '王雷', '男', 29, 'C789012', '2024-05-03', '王医生', 3);
INSERT INTO `patients` VALUES (4, '赵雪', '女', 40, 'D345678', '2024-05-04', '赵医生', 4);

SET FOREIGN_KEY_CHECKS = 1;
