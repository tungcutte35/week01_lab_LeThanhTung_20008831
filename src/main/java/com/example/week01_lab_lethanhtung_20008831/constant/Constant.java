package com.example.week01_lab_lethanhtung_20008831.constant;

import com.example.week01_lab_lethanhtung_20008831.models.ISGRANT;
import com.example.week01_lab_lethanhtung_20008831.models.STATUS;

import java.util.HashMap;
import java.util.Map;

public interface Constant {
    Map<STATUS, Integer> MAPSTATUS = new HashMap<>(
            Map.of(
                    STATUS.ACTIVE, 1,
                    STATUS.DEACTIVE, 0,
                    STATUS.DELETED, -1
            )
    );

    Map<ISGRANT, Integer> MAPISGRANT = new HashMap<>(
            Map.of(
                    ISGRANT.ENABLED, 1,
                    ISGRANT.DISABLED, 0
            )
    );
}