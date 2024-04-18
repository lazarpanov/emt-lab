import React from 'react';

const categories=(props)=>{
    return(
        <div className={"container-fluid"}>
            <div>
                <table className={"table table-striped"}>
                    <thead>
                    <tr>
                        <th scope={"col"}>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {props.categories.map((term) => {
                        return (
                            <tr key={term}>
                                <td>{term}</td>
                            </tr>
                        );
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default categories;