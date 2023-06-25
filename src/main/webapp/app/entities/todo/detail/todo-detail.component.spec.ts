import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { TodoDetailComponent } from './todo-detail.component';

describe('Todo Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TodoDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: TodoDetailComponent,
              resolve: { todo: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding()
        ),
      ],
    })
      .overrideTemplate(TodoDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load todo on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', TodoDetailComponent);

      // THEN
      expect(instance.todo).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
