/*
 * Copyright 2012 Igor Motov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elasticsearch.index.analysis.morphology;

import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.morphology.english.EnglishMorphologyAnalyzerProvider;
import org.elasticsearch.index.analysis.morphology.english.EnglishMorphologyTokenFilterFactory;
import org.elasticsearch.index.analysis.morphology.english.EnglishWordFormTokenFilterFactory;
import org.elasticsearch.index.analysis.morphology.russian.RussianMorphologyAnalyzerProvider;
import org.elasticsearch.index.analysis.morphology.russian.RussianMorphologyTokenFilterFactory;
import org.elasticsearch.index.analysis.morphology.russian.RussianWordFormTokenFilterFactory;

/**
 *
 */
public class MorphologyAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer("russian_morphology", RussianMorphologyAnalyzerProvider.class);
        analyzersBindings.processAnalyzer("english_morphology", EnglishMorphologyAnalyzerProvider.class);
    }

    @Override
    public void processTokenFilters(TokenFiltersBindings tokenFiltersBindings) {
        tokenFiltersBindings.processTokenFilter("russian_morphology", RussianMorphologyTokenFilterFactory.class);
        tokenFiltersBindings.processTokenFilter("english_morphology", EnglishMorphologyTokenFilterFactory.class);
        tokenFiltersBindings.processTokenFilter("russian_word_form", RussianWordFormTokenFilterFactory.class);
        tokenFiltersBindings.processTokenFilter("english_word_form", EnglishWordFormTokenFilterFactory.class);
    }

}
