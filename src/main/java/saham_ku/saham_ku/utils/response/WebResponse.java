package saham_ku.saham_ku.utils.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {
    private String status;
    private String message;
    private T data;
}
