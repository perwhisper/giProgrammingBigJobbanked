package com.wfg.service;

import com.wfg.dto.ScoreBoardDTO;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    Map<String, List<ScoreBoardDTO>> getScoreBorad();
}
