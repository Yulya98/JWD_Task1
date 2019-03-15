package by.epam.javawebtraining.kukareko.task1.stream.writer;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.*;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Magazine;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class BuildStringPublicationWriter {

    private static final String SPLIT_SYMBOL = " ";
    private static final String END_STR_DATA_SYMBOL = "\'";
    private static final String END_STR = " \n";

    public static String builderPublicationStr(Publication publication) {
        StringBuilder data = writeGeneralObjectField(publication);

        if (publication instanceof Book) {
            data.append("author='" + ((Book) publication).getAuthor() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);

            if (publication instanceof Children) {
                data.append("recommendedAge='" + ((Children) publication).getRecommendedAge()
                        + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
                return data.append(END_STR).toString();

            } else if (publication instanceof Technical) {
                data.append("subjectArea='" + ((Technical) publication).getSubjectArea()
                        + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
                data.append("level='" + ((Technical) publication).getLevel() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);

                if (publication instanceof Programming) {
                    data.append("language='" + ((Programming) publication).getLanguage()
                            + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
                    return data.append(END_STR).toString();
                }
                data.append("subject='" + ((Instruction) publication).getSubject() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
                return data.append(END_STR).toString();

            }
        } else if (publication instanceof Magazine) {
            data.append("countArticles=" + ((Magazine) publication).getCountAriticles() + SPLIT_SYMBOL);

            if (publication instanceof Musical) {
                data.append("kindMusical=" + ((Musical) publication).getKindMusical() + SPLIT_SYMBOL);
            } else if (publication instanceof Science) {
                data.append("subjectArea='" + ((Science) publication).getSubjectArea()
                        + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
            }
            data.append("kindSport=" + ((Sport) publication).getKindSport() + SPLIT_SYMBOL);
            return data.append(END_STR).toString();
        }

        data.append("format='" + ((Album) publication).getFormat() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
        return data.append(END_STR).toString();
    }

    private static StringBuilder writeGeneralObjectField(Publication publication) {
        StringBuilder data = writePackegeName(publication);

        data.append("id=" + publication.getId() + SPLIT_SYMBOL);
        data.append("pageCount=" + publication.getPageCount() + SPLIT_SYMBOL);
        data.append("name='" + publication.getName() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
        data.append("font=" + publication.getFont() + SPLIT_SYMBOL);
        data.append("publishing='" + publication.getPublishing() + END_STR_DATA_SYMBOL + SPLIT_SYMBOL);
        data.append("circulation=" + publication.getCirculation() + SPLIT_SYMBOL);
        data.append("rating=" + publication.getRating() + SPLIT_SYMBOL);

        return data;
    }

    private static StringBuilder writePackegeName(Publication publication) {
        StringBuilder data = new StringBuilder();

        if (publication instanceof Children) {
            data.append("book.Children" + SPLIT_SYMBOL);
        } else if (publication instanceof Programming) {
            data.append("book.Programming" + SPLIT_SYMBOL);
        } else if (publication instanceof Instruction) {
            data.append("book.Instruction" + SPLIT_SYMBOL);
        } else if (publication instanceof Musical) {
            data.append("magazine.Musical" + SPLIT_SYMBOL);
        } else if (publication instanceof Science) {
            data.append("magazine.Science" + SPLIT_SYMBOL);
        } else if (publication instanceof Sport) {
            data.append("magazine.Sport" + SPLIT_SYMBOL);
        } else if (publication instanceof Album) {
            data.append("album.Album" + SPLIT_SYMBOL);
        }

        return data;
    }
}
