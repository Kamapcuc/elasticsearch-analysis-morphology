package org.elasticsearch.index.analysis.morphology.english;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.morphology.analyzer.WordFormFilter;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;

public class EnglishWordFormTokenFilterFactory  extends EnglishMorphologyTokenFilterFactory{

    private final String[] grammemas;

    @Inject
    public EnglishWordFormTokenFilterFactory(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
        grammemas = settings.getAsArray("grammemas");
        if (grammemas == null)
            throw new IllegalArgumentException("Grammemas must be specified english_word_form token filter");
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new WordFormFilter(tokenStream, luceneMorph, grammemas);
    }

}
