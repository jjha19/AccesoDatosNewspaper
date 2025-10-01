package newspapercrud.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String name;
    private TypeDTO typeUi;
    private int avgRating;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------------------------\n")
                .append("id=").append(id).append("\n")
               .append("name=").append(name).append("\n")
               .append("typeUi=").append(typeUi).append("\n")
               .append("avgRating=").append(avgRating).append("\n")
               .append("\n");
        return builder.toString();
    }
}
